package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlegoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlegoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlegoumaiView;


/**
 * 音乐购买
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
public interface YinlegoumaiService extends IService<YinlegoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlegoumaiVO> selectListVO(Wrapper<YinlegoumaiEntity> wrapper);
   	
   	YinlegoumaiVO selectVO(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);
   	
   	List<YinlegoumaiView> selectListView(Wrapper<YinlegoumaiEntity> wrapper);
   	
   	YinlegoumaiView selectView(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlegoumaiEntity> wrapper);

   	

}

