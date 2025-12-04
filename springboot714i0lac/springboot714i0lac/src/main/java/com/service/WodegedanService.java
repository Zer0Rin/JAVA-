package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodegedanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodegedanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodegedanView;


/**
 * 我的歌单
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface WodegedanService extends IService<WodegedanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodegedanVO> selectListVO(Wrapper<WodegedanEntity> wrapper);
   	
   	WodegedanVO selectVO(@Param("ew") Wrapper<WodegedanEntity> wrapper);
   	
   	List<WodegedanView> selectListView(Wrapper<WodegedanEntity> wrapper);
   	
   	WodegedanView selectView(@Param("ew") Wrapper<WodegedanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodegedanEntity> wrapper);

   	

}

