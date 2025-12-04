package com.dao;

import com.entity.YinlegoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlegoumaiVO;
import com.entity.view.YinlegoumaiView;


/**
 * 音乐购买
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
public interface YinlegoumaiDao extends BaseMapper<YinlegoumaiEntity> {
	
	List<YinlegoumaiVO> selectListVO(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);
	
	YinlegoumaiVO selectVO(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);
	
	List<YinlegoumaiView> selectListView(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);

	List<YinlegoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);

	
	YinlegoumaiView selectView(@Param("ew") Wrapper<YinlegoumaiEntity> wrapper);
	

}
