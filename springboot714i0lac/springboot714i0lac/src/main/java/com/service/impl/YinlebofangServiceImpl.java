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


import com.dao.YinlebofangDao;
import com.entity.YinlebofangEntity;
import com.service.YinlebofangService;
import com.entity.vo.YinlebofangVO;
import com.entity.view.YinlebofangView;

@Service("yinlebofangService")
public class YinlebofangServiceImpl extends ServiceImpl<YinlebofangDao, YinlebofangEntity> implements YinlebofangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlebofangEntity> page = this.selectPage(
                new Query<YinlebofangEntity>(params).getPage(),
                new EntityWrapper<YinlebofangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlebofangEntity> wrapper) {
		  Page<YinlebofangView> page =new Query<YinlebofangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YinlebofangVO> selectListVO(Wrapper<YinlebofangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlebofangVO selectVO(Wrapper<YinlebofangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlebofangView> selectListView(Wrapper<YinlebofangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlebofangView selectView(Wrapper<YinlebofangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
