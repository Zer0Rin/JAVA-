package com.dao;

import com.entity.DiscusszaixianshitingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszaixianshitingVO;
import com.entity.view.DiscusszaixianshitingView;


/**
 * 在线试听评论表
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:24
 */
public interface DiscusszaixianshitingDao extends BaseMapper<DiscusszaixianshitingEntity> {
	
	List<DiscusszaixianshitingVO> selectListVO(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);
	
	DiscusszaixianshitingVO selectVO(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);
	
	List<DiscusszaixianshitingView> selectListView(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);

	List<DiscusszaixianshitingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);

	
	DiscusszaixianshitingView selectView(@Param("ew") Wrapper<DiscusszaixianshitingEntity> wrapper);
	

}
