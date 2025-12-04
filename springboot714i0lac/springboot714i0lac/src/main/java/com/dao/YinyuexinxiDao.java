package com.dao;

import com.entity.YinyuexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinyuexinxiVO;
import com.entity.view.YinyuexinxiView;


/**
 * 音乐信息
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public interface YinyuexinxiDao extends BaseMapper<YinyuexinxiEntity> {
	
	List<YinyuexinxiVO> selectListVO(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);
	
	YinyuexinxiVO selectVO(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);
	
	List<YinyuexinxiView> selectListView(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);

	List<YinyuexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);

	
	YinyuexinxiView selectView(@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinyuexinxiEntity> wrapper);



}
