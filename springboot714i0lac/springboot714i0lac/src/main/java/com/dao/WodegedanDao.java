package com.dao;

import com.entity.WodegedanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodegedanVO;
import com.entity.view.WodegedanView;


/**
 * 我的歌单
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface WodegedanDao extends BaseMapper<WodegedanEntity> {
	
	List<WodegedanVO> selectListVO(@Param("ew") Wrapper<WodegedanEntity> wrapper);
	
	WodegedanVO selectVO(@Param("ew") Wrapper<WodegedanEntity> wrapper);
	
	List<WodegedanView> selectListView(@Param("ew") Wrapper<WodegedanEntity> wrapper);

	List<WodegedanView> selectListView(Pagination page,@Param("ew") Wrapper<WodegedanEntity> wrapper);

	
	WodegedanView selectView(@Param("ew") Wrapper<WodegedanEntity> wrapper);
	

}
