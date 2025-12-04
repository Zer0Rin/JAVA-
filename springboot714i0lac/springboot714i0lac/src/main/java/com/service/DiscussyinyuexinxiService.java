package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyinyuexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyinyuexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyinyuexinxiView;


/**
 * yinyuexinxi评论表
 *
 * @author 
 * @email 
 * @date 2025-12-03 09:16:24
 */
public interface DiscussyinyuexinxiService extends IService<DiscussyinyuexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinyuexinxiVO> selectListVO(Wrapper<DiscussyinyuexinxiEntity> wrapper);
   	
   	DiscussyinyuexinxiVO selectVO(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);
   	
   	List<DiscussyinyuexinxiView> selectListView(Wrapper<DiscussyinyuexinxiEntity> wrapper);
   	
   	DiscussyinyuexinxiView selectView(@Param("ew") Wrapper<DiscussyinyuexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinyuexinxiEntity> wrapper);

   	

}

