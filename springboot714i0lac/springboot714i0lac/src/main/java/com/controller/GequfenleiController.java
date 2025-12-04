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

import com.entity.GequfenleiEntity;
import com.entity.view.GequfenleiView;

import com.service.GequfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 歌曲分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
@RestController
@RequestMapping("/gequfenlei")
public class GequfenleiController {
    @Autowired
    private GequfenleiService gequfenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GequfenleiEntity gequfenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();


        //查询结果
		PageUtils page = gequfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequfenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GequfenleiEntity gequfenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();

        //查询结果
		PageUtils page = gequfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequfenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GequfenleiEntity gequfenlei){
       	EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gequfenlei, "gequfenlei")); 
        return R.ok().put("data", gequfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GequfenleiEntity gequfenlei){
        EntityWrapper< GequfenleiEntity> ew = new EntityWrapper< GequfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gequfenlei, "gequfenlei")); 
		GequfenleiView gequfenleiView =  gequfenleiService.selectView(ew);
		return R.ok("查询歌曲分类成功").put("data", gequfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GequfenleiEntity gequfenlei = gequfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gequfenlei,deSens);
        return R.ok().put("data", gequfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GequfenleiEntity gequfenlei = gequfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gequfenlei,deSens);
        return R.ok().put("data", gequfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(gequfenleiService.selectCount(new EntityWrapper<GequfenleiEntity>().eq("gequfenlei", gequfenlei.getGequfenlei()))>0) {
            return R.error("歌曲分类已存在");
        }
        //ValidatorUtils.validateEntity(gequfenlei);
        gequfenleiService.insert(gequfenlei);
        return R.ok().put("data",gequfenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(gequfenleiService.selectCount(new EntityWrapper<GequfenleiEntity>().eq("gequfenlei", gequfenlei.getGequfenlei()))>0) {
            return R.error("歌曲分类已存在");
        }
        //ValidatorUtils.validateEntity(gequfenlei);
        gequfenleiService.insert(gequfenlei);
        return R.ok().put("data",gequfenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gequfenlei);
        //验证字段唯一性，否则返回错误信息
        if(gequfenleiService.selectCount(new EntityWrapper<GequfenleiEntity>().ne("id", gequfenlei.getId()).eq("gequfenlei", gequfenlei.getGequfenlei()))>0) {
            return R.error("歌曲分类已存在");
        }
        //全部更新
        gequfenleiService.updateById(gequfenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gequfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
