package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                // 👇👇👇 【新增】放行 AI 的接口，不进行登录拦截 👇👇👇
                .excludePathPatterns("/api/ai/**")
                // 👇👇👇 【新增】放行 AI 的前端页面文件（以防万一） 👇👇👇
                .excludePathPatterns("/ai/**");

        super.addInterceptors(registry);
    }

    /**
     * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置 AI 文件夹的映射：让 /ai/** 的请求能找到 classpath:/ai/ 目录下的文件
        registry.addResourceHandler("/ai/**")
                .addResourceLocations("classpath:/ai/");

        // 原有的通用配置
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/admin/")
                .addResourceLocations("classpath:/front/")
                .addResourceLocations("classpath:/front-pc/")
                .addResourceLocations("classpath:/public/");

        super.addResourceHandlers(registry);
    }
}