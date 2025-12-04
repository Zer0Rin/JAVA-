package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinyuexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinyuexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinyuexinxiView;


/**
 * 音乐信息
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface YinyuexinxiService extends IService<YinyuexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinyuexinxiVO> selectListVO(Wrapper<YinyuexinxiEntity> wrapper);
   	
   	YinyuexinxiVO selectVO(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);
   	
   	List<YinyuexinxiView> selectListView(Wrapper<YinyuexinxiEntity> wrapper);
   	
   	YinyuexinxiView selectView(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinyuexinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YinyuexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YinyuexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YinyuexinxiEntity> wrapper);



}

