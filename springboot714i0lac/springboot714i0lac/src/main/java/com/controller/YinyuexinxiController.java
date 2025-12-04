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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.YinyuexinxiEntity;
import com.entity.view.YinyuexinxiView;

import com.service.YinyuexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 音乐信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
@RestController
@RequestMapping("/yinyuexinxi")
public class YinyuexinxiController {
    @Autowired
    private YinyuexinxiService yinyuexinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinyuexinxiEntity yinyuexinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();


        //查询结果
		PageUtils page = yinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinyuexinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YinyuexinxiEntity yinyuexinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();

        //查询结果
		PageUtils page = yinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinyuexinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinyuexinxiEntity yinyuexinxi){
       	EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinyuexinxi, "yinyuexinxi")); 
        return R.ok().put("data", yinyuexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinyuexinxiEntity yinyuexinxi){
        EntityWrapper< YinyuexinxiEntity> ew = new EntityWrapper< YinyuexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinyuexinxi, "yinyuexinxi")); 
		YinyuexinxiView yinyuexinxiView =  yinyuexinxiService.selectView(ew);
		return R.ok("查询音乐信息成功").put("data", yinyuexinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinyuexinxiEntity yinyuexinxi = yinyuexinxiService.selectById(id);
        if(null==yinyuexinxi.getClicknum()){
            yinyuexinxi.setClicknum(0);
        }
		yinyuexinxi.setClicknum(yinyuexinxi.getClicknum()+1);
		yinyuexinxiService.updateById(yinyuexinxi);
        yinyuexinxi = yinyuexinxiService.selectView(new EntityWrapper<YinyuexinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinyuexinxi,deSens);
        return R.ok().put("data", yinyuexinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinyuexinxiEntity yinyuexinxi = yinyuexinxiService.selectById(id);
        if(null==yinyuexinxi.getClicknum()){
            yinyuexinxi.setClicknum(0);
        }
		yinyuexinxi.setClicknum(yinyuexinxi.getClicknum()+1);
		yinyuexinxiService.updateById(yinyuexinxi);
        yinyuexinxi = yinyuexinxiService.selectView(new EntityWrapper<YinyuexinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinyuexinxi,deSens);
        return R.ok().put("data", yinyuexinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinyuexinxiEntity yinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinyuexinxi);
        yinyuexinxiService.insert(yinyuexinxi);
        return R.ok().put("data",yinyuexinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinyuexinxiEntity yinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinyuexinxi);
        yinyuexinxiService.insert(yinyuexinxi);
        return R.ok().put("data",yinyuexinxi.getId());
    }

    /**
     * 批量生成数据
     */
    @RequestMapping("/batch/gen")
    public R batch(int recordNum){
        List<YinyuexinxiEntity> list = yinyuexinxiService.selectList(new EntityWrapper<YinyuexinxiEntity>().last("order by rand() limit 50"));
        if(list!=null && list.size()>0 && recordNum>0) {
            List<YinyuexinxiEntity> batchList = new ArrayList<YinyuexinxiEntity>(recordNum);
            int max = list.size();
            Random random = new Random();
            for(int i=0;i<recordNum;i++) {
                YinyuexinxiEntity yinyuexinxi = new YinyuexinxiEntity();
               yinyuexinxi.setTitle(list.get(random.nextInt(max)).getTitle());
               yinyuexinxi.setPicture(list.get(random.nextInt(max)).getPicture());
               yinyuexinxi.setZuozhe(list.get(random.nextInt(max)).getZuozhe());
               yinyuexinxi.setShoucang(list.get(random.nextInt(max)).getShoucang());
               yinyuexinxi.setShare(list.get(random.nextInt(max)).getShare());
               yinyuexinxi.setPinglun(list.get(random.nextInt(max)).getPinglun());
               yinyuexinxi.setBofang(list.get(random.nextInt(max)).getBofang());
               yinyuexinxi.setGqlb(list.get(random.nextInt(max)).getGqlb());
               yinyuexinxi.setXqdz(list.get(random.nextInt(max)).getXqdz());
               yinyuexinxi.setJieshao(list.get(random.nextInt(max)).getJieshao());
               yinyuexinxi.setClicktime(list.get(random.nextInt(max)).getClicktime());
               yinyuexinxi.setClicknum(list.get(random.nextInt(max)).getClicknum());
               yinyuexinxi.setDiscussnum(list.get(random.nextInt(max)).getDiscussnum());
               yinyuexinxi.setStoreupnum(list.get(random.nextInt(max)).getStoreupnum());
                batchList.add(yinyuexinxi);
            }
            yinyuexinxiService.insertBatch(batchList);
        }
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinyuexinxiEntity yinyuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinyuexinxi);
        //全部更新
        yinyuexinxiService.updateById(yinyuexinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinyuexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YinyuexinxiEntity yinyuexinxi, HttpServletRequest request,String pre){
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");

		PageUtils page = yinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinyuexinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YinyuexinxiEntity yinyuexinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "yinyuexinxi"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0 && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        // 根据协同结果查询结果并返回
        PageUtils page = yinyuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinyuexinxi), params), params));;
        List<YinyuexinxiEntity> pageList = (List<YinyuexinxiEntity>)page.getList();
        if(recommendations!=null && recommendations.size()>0 && pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<YinyuexinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(yinyuexinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
            //获取结果
        List<Map<String, Object>> result = yinyuexinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yinyuexinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        List<Map<String, Object>> result = yinyuexinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yinyuexinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        List<Map<String, Object>> result = yinyuexinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YinyuexinxiEntity yinyuexinxi, HttpServletRequest request){
        EntityWrapper<YinyuexinxiEntity> ew = new EntityWrapper<YinyuexinxiEntity>();
        int count = yinyuexinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinyuexinxi), params), params));
        return R.ok().put("data", count);
    }

}
