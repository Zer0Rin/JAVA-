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


import com.dao.ZaixianshitingDao;
import com.entity.ZaixianshitingEntity;
import com.service.ZaixianshitingService;
import com.entity.vo.ZaixianshitingVO;
import com.entity.view.ZaixianshitingView;

@Service("zaixianshitingService")
public class ZaixianshitingServiceImpl extends ServiceImpl<ZaixianshitingDao, ZaixianshitingEntity> implements ZaixianshitingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianshitingEntity> page = this.selectPage(
                new Query<ZaixianshitingEntity>(params).getPage(),
                new EntityWrapper<ZaixianshitingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianshitingEntity> wrapper) {
		  Page<ZaixianshitingView> page =new Query<ZaixianshitingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZaixianshitingVO> selectListVO(Wrapper<ZaixianshitingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianshitingVO selectVO(Wrapper<ZaixianshitingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianshitingView> selectListView(Wrapper<ZaixianshitingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianshitingView selectView(Wrapper<ZaixianshitingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
