package com.dao;

import com.entity.DiscussyinyuexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinyuexinxiVO;
import com.entity.view.DiscussyinyuexinxiView;


/**
 * yinyuexinxi评论表
 * 
 * @author 
 * @email 
 * @date 2025-12-03 09:16:24
 */
public interface DiscussyinyuexinxiDao extends BaseMapper<DiscussyinyuexinxiEntity> {
	
	List<DiscussyinyuexinxiVO> selectListVO(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);
	
	DiscussyinyuexinxiVO selectVO(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);
	
	List<DiscussyinyuexinxiView> selectListView(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);

	List<DiscussyinyuexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);

	
	DiscussyinyuexinxiView selectView(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);
	

}
