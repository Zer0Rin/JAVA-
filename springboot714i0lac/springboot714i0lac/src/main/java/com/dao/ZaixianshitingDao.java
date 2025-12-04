package com.dao;

import com.entity.ZaixianshitingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianshitingVO;
import com.entity.view.ZaixianshitingView;


/**
 * 在线试听
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
public interface ZaixianshitingDao extends BaseMapper<ZaixianshitingEntity> {
	
	List<ZaixianshitingVO> selectListVO(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);
	
	ZaixianshitingVO selectVO(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);
	
	List<ZaixianshitingView> selectListView(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);

	List<ZaixianshitingView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);

	
	ZaixianshitingView selectView(@Param("ew") Wrapper<ZaixianshitingEntity> wrapper);
	

}
