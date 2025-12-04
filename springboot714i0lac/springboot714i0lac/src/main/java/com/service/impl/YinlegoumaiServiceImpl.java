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


import com.dao.YinlegoumaiDao;
import com.entity.YinlegoumaiEntity;
import com.service.YinlegoumaiService;
import com.entity.vo.YinlegoumaiVO;
import com.entity.view.YinlegoumaiView;

@Service("yinlegoumaiService")
public class YinlegoumaiServiceImpl extends ServiceImpl<YinlegoumaiDao, YinlegoumaiEntity> implements YinlegoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlegoumaiEntity> page = this.selectPage(
                new Query<YinlegoumaiEntity>(params).getPage(),
                new EntityWrapper<YinlegoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlegoumaiEntity> wrapper) {
		  Page<YinlegoumaiView> page =new Query<YinlegoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YinlegoumaiVO> selectListVO(Wrapper<YinlegoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlegoumaiVO selectVO(Wrapper<YinlegoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlegoumaiView> selectListView(Wrapper<YinlegoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlegoumaiView selectView(Wrapper<YinlegoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
