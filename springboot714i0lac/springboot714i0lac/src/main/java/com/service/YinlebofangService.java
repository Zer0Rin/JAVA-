package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlebofangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlebofangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlebofangView;


/**
 * 音乐播放
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface YinlebofangService extends IService<YinlebofangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlebofangVO> selectListVO(Wrapper<YinlebofangEntity> wrapper);
   	
   	YinlebofangVO selectVO(@Param("ew") Wrapper<YinlebofangEntity> wrapper);
   	
   	List<YinlebofangView> selectListView(Wrapper<YinlebofangEntity> wrapper);
   	
   	YinlebofangView selectView(@Param("ew") Wrapper<YinlebofangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlebofangEntity> wrapper);

   	

}

