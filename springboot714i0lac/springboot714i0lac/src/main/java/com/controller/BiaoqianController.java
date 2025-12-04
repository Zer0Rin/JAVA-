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

import com.entity.BiaoqianEntity;
import com.entity.view.BiaoqianView;

import com.service.BiaoqianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 标签
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
@RestController
@RequestMapping("/biaoqian")
public class BiaoqianController {
    @Autowired
    private BiaoqianService biaoqianService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BiaoqianEntity biaoqian,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();


        //查询结果
		PageUtils page = biaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaoqian), params), params));
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
    public R list(@RequestParam Map<String, Object> params,BiaoqianEntity biaoqian, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();

        //查询结果
		PageUtils page = biaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaoqian), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BiaoqianEntity biaoqian){
       	EntityWrapper<BiaoqianEntity> ew = new EntityWrapper<BiaoqianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( biaoqian, "biaoqian")); 
        return R.ok().put("data", biaoqianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BiaoqianEntity biaoqian){
        EntityWrapper< BiaoqianEntity> ew = new EntityWrapper< BiaoqianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( biaoqian, "biaoqian")); 
		BiaoqianView biaoqianView =  biaoqianService.selectView(ew);
		return R.ok("查询标签成功").put("data", biaoqianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BiaoqianEntity biaoqian = biaoqianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(biaoqian,deSens);
        return R.ok().put("data", biaoqian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BiaoqianEntity biaoqian = biaoqianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(biaoqian,deSens);
        return R.ok().put("data", biaoqian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(biaoqianService.selectCount(new EntityWrapper<BiaoqianEntity>().eq("biaoqian", biaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
        //ValidatorUtils.validateEntity(biaoqian);
        biaoqianService.insert(biaoqian);
        return R.ok().put("data",biaoqian.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(biaoqianService.selectCount(new EntityWrapper<BiaoqianEntity>().eq("biaoqian", biaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
        //ValidatorUtils.validateEntity(biaoqian);
        biaoqianService.insert(biaoqian);
        return R.ok().put("data",biaoqian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BiaoqianEntity biaoqian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(biaoqian);
        //验证字段唯一性，否则返回错误信息
        if(biaoqianService.selectCount(new EntityWrapper<BiaoqianEntity>().ne("id", biaoqian.getId()).eq("biaoqian", biaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
        //全部更新
        biaoqianService.updateById(biaoqian);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        biaoqianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
