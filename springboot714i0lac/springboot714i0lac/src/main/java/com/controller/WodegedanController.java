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

import com.entity.WodegedanEntity;
import com.entity.view.WodegedanView;

import com.service.WodegedanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的歌单
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
@RestController
@RequestMapping("/wodegedan")
public class WodegedanController {
    @Autowired
    private WodegedanService wodegedanService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodegedanEntity wodegedan,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            wodegedan.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        //设置查询条件
        EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();


        //查询结果
		PageUtils page = wodegedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodegedan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodegedanEntity wodegedan, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wodegedan.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        //设置查询条件
        EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();

        //查询结果
		PageUtils page = wodegedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodegedan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodegedanEntity wodegedan){
       	EntityWrapper<WodegedanEntity> ew = new EntityWrapper<WodegedanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodegedan, "wodegedan")); 
        return R.ok().put("data", wodegedanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodegedanEntity wodegedan){
        EntityWrapper< WodegedanEntity> ew = new EntityWrapper< WodegedanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodegedan, "wodegedan")); 
		WodegedanView wodegedanView =  wodegedanService.selectView(ew);
		return R.ok("查询我的歌单成功").put("data", wodegedanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodegedanEntity wodegedan = wodegedanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wodegedan,deSens);
        return R.ok().put("data", wodegedan);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodegedanEntity wodegedan = wodegedanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wodegedan,deSens);
        return R.ok().put("data", wodegedan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodegedan);
    	wodegedan.setUserid((Long)request.getSession().getAttribute("userId"));
        wodegedanService.insert(wodegedan);
        return R.ok().put("data",wodegedan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodegedan);
    	wodegedan.setUserid((Long)request.getSession().getAttribute("userId"));
        wodegedanService.insert(wodegedan);
        return R.ok().put("data",wodegedan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WodegedanEntity wodegedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodegedan);
        //全部更新
        wodegedanService.updateById(wodegedan);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodegedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
