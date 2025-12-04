package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszaixianshitingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszaixianshitingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszaixianshitingView;


/**
 * 在线试听评论表
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:24
 */
public interface DiscusszaixianshitingService extends IService<DiscusszaixianshitingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszaixianshitingVO> selectListVO(Wrapper<DiscusszaixianshitingEntity> wrapper);
   	
   	DiscusszaixianshitingVO selectVO(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);
   	
   	List<DiscusszaixianshitingView> selectListView(Wrapper<DiscusszaixianshitingEntity> wrapper);
   	
   	DiscusszaixianshitingView selectView(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszaixianshitingEntity> wrapper);

   	

}

