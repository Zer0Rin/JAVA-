package com.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;

import com.annotation.IgnoreAuth;
import com.entity.TokenEntity;
import com.service.TokenService;
import com.utils.R;

/**
 * 权限(Token)验证
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    public static final String LOGIN_TOKEN_KEY = "Token";

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        // 【调试日志 1】看看请求的地址到底是什么
        System.out.println("========== 拦截器收到请求: " + uri + " ==========");

        // 1. 先设置 Header (解决跨域和乱码问题)
        // 必须先做这一步，否则直接 return true 会导致前端收不到响应头
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,request-source,Token, Origin,imgType, Content-Type, cache-control,postman-token,Cookie, Accept,authorization");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        // 2. 处理 OPTIONS 预检请求
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }

        // 3. 【重点】检查是否是 AI 接口，如果是，直接放行
        // 这一步必须放在设置 Header 之后，Token 检查之前
        if (uri.contains("/api/ai") || uri.contains("/ai.html")) {
            System.out.println("========== 检测到 AI 接口，直接放行！ ==========");
            return true;
        }

        // ... 下面是原本的 Token 验证逻辑 ...
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        String token = request.getHeader(LOGIN_TOKEN_KEY);

        if(annotation!=null) {
            return true;
        }

        TokenEntity tokenEntity = null;
        if(StringUtils.isNotBlank(token)) {
            tokenEntity = tokenService.getTokenEntity(token);
        }

        if(tokenEntity != null) {
            request.getSession().setAttribute("userId", tokenEntity.getUserid());
            request.getSession().setAttribute("role", tokenEntity.getRole());
            request.getSession().setAttribute("tableName", tokenEntity.getTablename());
            request.getSession().setAttribute("username", tokenEntity.getUsername());
            return true;
        }

        // 验证失败，返回 401
        System.out.println("========== 权限验证失败，拦截请求 ==========");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(R.error(401, "请检查是否授予权限，请求将跳转登录页面！")));
        } finally {
            if(writer != null){
                writer.close();
            }
        }
        return false;
    }
}