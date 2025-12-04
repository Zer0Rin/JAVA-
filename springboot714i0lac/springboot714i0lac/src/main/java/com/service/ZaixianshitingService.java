package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianshitingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianshitingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianshitingView;


/**
 * 在线试听
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
public interface ZaixianshitingService extends IService<ZaixianshitingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianshitingVO> selectListVO(Wrapper<ZaixianshitingEntity> wrapper);
   	
   	ZaixianshitingVO selectVO(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);
   	
   	List<ZaixianshitingView> selectListView(Wrapper<ZaixianshitingEntity> wrapper);
   	
   	ZaixianshitingView selectView(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianshitingEntity> wrapper);

   	

}

