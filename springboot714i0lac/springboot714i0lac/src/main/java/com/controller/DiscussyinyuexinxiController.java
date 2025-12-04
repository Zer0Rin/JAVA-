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

import com.entity.DiscussyinyuexinxiEntity;
import com.entity.view.DiscussyinyuexinxiView;

import com.service.DiscussyinyuexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * yinyuexinxi评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:24
 */
@RestController
@RequestMapping("/discussyinyuexinxi")
public class DiscussyinyuexinxiController {
    @Autowired
    private DiscussyinyuexinxiService discussyinyuexinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyinyuexinxiEntity discussyinyuexinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussyinyuexinxiEntity> ew = new EntityWrapper<DiscussyinyuexinxiEntity>();


        //查询结果
		PageUtils page = discussyinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinyuexinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussyinyuexinxiEntity discussyinyuexinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussyinyuexinxiEntity> ew = new EntityWrapper<DiscussyinyuexinxiEntity>();

        //查询结果
		PageUtils page = discussyinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinyuexinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyinyuexinxiEntity discussyinyuexinxi){
       	EntityWrapper<DiscussyinyuexinxiEntity> ew = new EntityWrapper<DiscussyinyuexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyinyuexinxi, "discussyinyuexinxi")); 
        return R.ok().put("data", discussyinyuexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyinyuexinxiEntity discussyinyuexinxi){
        EntityWrapper< DiscussyinyuexinxiEntity> ew = new EntityWrapper< DiscussyinyuexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyinyuexinxi, "discussyinyuexinxi")); 
		DiscussyinyuexinxiView discussyinyuexinxiView =  discussyinyuexinxiService.selectView(ew);
		return R.ok("查询yinyuexinxi评论表成功").put("data", discussyinyuexinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyinyuexinxiEntity discussyinyuexinxi = discussyinyuexinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyinyuexinxi,deSens);
        return R.ok().put("data", discussyinyuexinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyinyuexinxiEntity discussyinyuexinxi = discussyinyuexinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyinyuexinxi,deSens);
        return R.ok().put("data", discussyinyuexinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyinyuexinxiEntity discussyinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyinyuexinxi);
        discussyinyuexinxiService.insert(discussyinyuexinxi);
        return R.ok().put("data",discussyinyuexinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyinyuexinxiEntity discussyinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyinyuexinxi);
        discussyinyuexinxiService.insert(discussyinyuexinxi);
        return R.ok().put("data",discussyinyuexinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyinyuexinxiEntity discussyinyuexinxi = discussyinyuexinxiService.selectOne(new EntityWrapper<DiscussyinyuexinxiEntity>().eq("", username));
        return R.ok().put("data", discussyinyuexinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyinyuexinxiEntity discussyinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyinyuexinxi);
        //全部更新
        discussyinyuexinxiService.updateById(discussyinyuexinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyinyuexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyinyuexinxiEntity discussyinyuexinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyinyuexinxiEntity> ew = new EntityWrapper<DiscussyinyuexinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discussyinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinyuexinxi), params), params));
        return R.ok().put("data", page);
    }








}
