package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyinyuexinxiDao;
import com.entity.DiscussyinyuexinxiEntity;
import com.service.DiscussyinyuexinxiService;
import com.entity.vo.DiscussyinyuexinxiVO;
import com.entity.view.DiscussyinyuexinxiView;

@Service("discussyinyuexinxiService")
public class DiscussyinyuexinxiServiceImpl extends ServiceImpl<DiscussyinyuexinxiDao, DiscussyinyuexinxiEntity> implements DiscussyinyuexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinyuexinxiEntity> page = this.selectPage(
                new Query<DiscussyinyuexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyinyuexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinyuexinxiEntity> wrapper) {
		  Page<DiscussyinyuexinxiView> page =new Query<DiscussyinyuexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyinyuexinxiVO> selectListVO(Wrapper<DiscussyinyuexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinyuexinxiVO selectVO(Wrapper<DiscussyinyuexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinyuexinxiView> selectListView(Wrapper<DiscussyinyuexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinyuexinxiView selectView(Wrapper<DiscussyinyuexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
