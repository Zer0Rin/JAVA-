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

import com.entity.YinlebofangEntity;
import com.entity.view.YinlebofangView;

import com.service.YinlebofangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 音乐播放
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
@RestController
@RequestMapping("/yinlebofang")
public class YinlebofangController {
    @Autowired
    private YinlebofangService yinlebofangService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlebofangEntity yinlebofang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinlebofang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YinlebofangEntity> ew = new EntityWrapper<YinlebofangEntity>();


        //查询结果
		PageUtils page = yinlebofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlebofang), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YinlebofangEntity yinlebofang, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinlebofangEntity> ew = new EntityWrapper<YinlebofangEntity>();

        //查询结果
		PageUtils page = yinlebofangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlebofang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlebofangEntity yinlebofang){
       	EntityWrapper<YinlebofangEntity> ew = new EntityWrapper<YinlebofangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlebofang, "yinlebofang")); 
        return R.ok().put("data", yinlebofangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlebofangEntity yinlebofang){
        EntityWrapper< YinlebofangEntity> ew = new EntityWrapper< YinlebofangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlebofang, "yinlebofang")); 
		YinlebofangView yinlebofangView =  yinlebofangService.selectView(ew);
		return R.ok("查询音乐播放成功").put("data", yinlebofangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlebofangEntity yinlebofang = yinlebofangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlebofang,deSens);
        return R.ok().put("data", yinlebofang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlebofangEntity yinlebofang = yinlebofangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlebofang,deSens);
        return R.ok().put("data", yinlebofang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlebofangEntity yinlebofang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlebofang);
        yinlebofangService.insert(yinlebofang);
        return R.ok().put("data",yinlebofang.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlebofangEntity yinlebofang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlebofang);
        yinlebofangService.insert(yinlebofang);
        return R.ok().put("data",yinlebofang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlebofangEntity yinlebofang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlebofang);
        //全部更新
        yinlebofangService.updateById(yinlebofang);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlebofangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
