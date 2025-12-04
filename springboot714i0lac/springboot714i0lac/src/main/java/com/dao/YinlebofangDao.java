package com.dao;

import com.entity.YinlebofangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlebofangVO;
import com.entity.view.YinlebofangView;


/**
 * 音乐播放
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface YinlebofangDao extends BaseMapper<YinlebofangEntity> {
	
	List<YinlebofangVO> selectListVO(@Param("ew") Wrapper<YinlebofangEntity> wrapper);
	
	YinlebofangVO selectVO(@Param("ew") Wrapper<YinlebofangEntity> wrapper);
	
	List<YinlebofangView> selectListView(@Param("ew") Wrapper<YinlebofangEntity> wrapper);

	List<YinlebofangView> selectListView(Pagination page,@Param("ew") Wrapper<YinlebofangEntity> wrapper);

	
	YinlebofangView selectView(@Param("ew") Wrapper<YinlebofangEntity> wrapper);
	

}
