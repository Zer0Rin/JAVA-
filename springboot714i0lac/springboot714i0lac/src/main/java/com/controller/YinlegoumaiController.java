package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YinlegoumaiEntity;
import com.entity.view.YinlegoumaiView;

import com.service.YinlegoumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.config.AlipayConfig;

/**
 * 音乐购买
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
@RestController
@RequestMapping("/yinlegoumai")
public class YinlegoumaiController {
    @Autowired
    private YinlegoumaiService yinlegoumaiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlegoumaiEntity yinlegoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinlegoumai.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();


        //查询结果
		PageUtils page = yinlegoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlegoumai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlegoumaiEntity yinlegoumai, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();

        //查询结果
		PageUtils page = yinlegoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlegoumai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlegoumaiEntity yinlegoumai){
       	EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlegoumai, "yinlegoumai")); 
        return R.ok().put("data", yinlegoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlegoumaiEntity yinlegoumai){
        EntityWrapper< YinlegoumaiEntity> ew = new EntityWrapper< YinlegoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlegoumai, "yinlegoumai")); 
		YinlegoumaiView yinlegoumaiView =  yinlegoumaiService.selectView(ew);
		return R.ok("查询音乐购买成功").put("data", yinlegoumaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlegoumaiEntity yinlegoumai = yinlegoumaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlegoumai,deSens);
        return R.ok().put("data", yinlegoumai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlegoumaiEntity yinlegoumai = yinlegoumaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlegoumai,deSens);
        return R.ok().put("data", yinlegoumai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlegoumai);
        yinlegoumaiService.insert(yinlegoumai);
        return R.ok().put("data",yinlegoumai.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlegoumai);
        yinlegoumaiService.insert(yinlegoumai);
        return R.ok().put("data",yinlegoumai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlegoumai);
        //全部更新
        yinlegoumaiService.updateById(yinlegoumai);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlegoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    




    /**
    * 支付宝支付
    */
    @RequestMapping("/alipay")
    public R payController(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) Integer isFront) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //构建支付宝支付对象
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //构建支付宝请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //设置详情页面地址
        if(isFront!=null && isFront==1) {
            alipayRequest.setReturnUrl(AlipayConfig.return_url_f+"index/yinlegoumai?centerType=1");
        } else {
            alipayRequest.setReturnUrl(AlipayConfig.return_url_b+"yinlegoumai");
        }
        //设置回调地址
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url+"yinlegoumai"+"/notify");

        String out_trade_no = new String(request.getParameter("tradeno"));
        String total_amount = new String(request.getParameter("totalamount").getBytes("ISO-8859-1"),"UTF-8");
        String subject = new String(request.getParameter("subject"));
        String body = "";
        //设置请求内容
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = "";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return R.ok().put("data",form);
    }

    /**
     * 功能：支付宝服务器异步通知页面
     *************************页面功能说明*************************
     * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
     * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
     * 如果没有收到该页面返回的 success
     * 建议该页面只做支付成功的业务逻辑处理，退款的处理请以调用退款查询接口的结果为准。
     */
    @IgnoreAuth
    @RequestMapping("notify")
    public R nofity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
        if(trade_status.equals("TRADE_FINISHED")){
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序

            //注意：
            //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
        }else if (trade_status.equals("TRADE_SUCCESS")){
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序

            //注意：
            //付款完成后，支付宝系统发送该交易状态通知
            YinlegoumaiEntity yinlegoumai = yinlegoumaiService.selectOne(new EntityWrapper<YinlegoumaiEntity>().eq("dingdanbianhao", out_trade_no));
            if(yinlegoumai!=null) {
                yinlegoumai.setIspay("已支付");
                yinlegoumaiService.updateById(yinlegoumai);
            }
        }
        //——请在这里编写您的程序（以上代码仅作参考）——
        return R.ok();
    }




}
