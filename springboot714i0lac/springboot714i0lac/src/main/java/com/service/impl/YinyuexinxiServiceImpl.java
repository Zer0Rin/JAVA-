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


import com.dao.YinyuexinxiDao;
import com.entity.YinyuexinxiEntity;
import com.service.YinyuexinxiService;
import com.entity.vo.YinyuexinxiVO;
import com.entity.view.YinyuexinxiView;

@Service("yinyuexinxiService")
public class YinyuexinxiServiceImpl extends ServiceImpl<YinyuexinxiDao, YinyuexinxiEntity> implements YinyuexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinyuexinxiEntity> page = this.selectPage(
                new Query<YinyuexinxiEntity>(params).getPage(),
                new EntityWrapper<YinyuexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinyuexinxiEntity> wrapper) {
		  Page<YinyuexinxiView> page =new Query<YinyuexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YinyuexinxiVO> selectListVO(Wrapper<YinyuexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinyuexinxiVO selectVO(Wrapper<YinyuexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinyuexinxiView> selectListView(Wrapper<YinyuexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinyuexinxiView selectView(Wrapper<YinyuexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YinyuexinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YinyuexinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YinyuexinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
