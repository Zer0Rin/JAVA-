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


import com.dao.DiscusszaixianshitingDao;
import com.entity.DiscusszaixianshitingEntity;
import com.service.DiscusszaixianshitingService;
import com.entity.vo.DiscusszaixianshitingVO;
import com.entity.view.DiscusszaixianshitingView;

@Service("discusszaixianshitingService")
public class DiscusszaixianshitingServiceImpl extends ServiceImpl<DiscusszaixianshitingDao, DiscusszaixianshitingEntity> implements DiscusszaixianshitingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszaixianshitingEntity> page = this.selectPage(
                new Query<DiscusszaixianshitingEntity>(params).getPage(),
                new EntityWrapper<DiscusszaixianshitingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszaixianshitingEntity> wrapper) {
		  Page<DiscusszaixianshitingView> page =new Query<DiscusszaixianshitingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusszaixianshitingVO> selectListVO(Wrapper<DiscusszaixianshitingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszaixianshitingVO selectVO(Wrapper<DiscusszaixianshitingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszaixianshitingView> selectListView(Wrapper<DiscusszaixianshitingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszaixianshitingView selectView(Wrapper<DiscusszaixianshitingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
