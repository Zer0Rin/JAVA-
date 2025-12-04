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


import com.dao.WodegedanDao;
import com.entity.WodegedanEntity;
import com.service.WodegedanService;
import com.entity.vo.WodegedanVO;
import com.entity.view.WodegedanView;

@Service("wodegedanService")
public class WodegedanServiceImpl extends ServiceImpl<WodegedanDao, WodegedanEntity> implements WodegedanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodegedanEntity> page = this.selectPage(
                new Query<WodegedanEntity>(params).getPage(),
                new EntityWrapper<WodegedanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodegedanEntity> wrapper) {
		  Page<WodegedanView> page =new Query<WodegedanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WodegedanVO> selectListVO(Wrapper<WodegedanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodegedanVO selectVO(Wrapper<WodegedanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodegedanView> selectListView(Wrapper<WodegedanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodegedanView selectView(Wrapper<WodegedanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
