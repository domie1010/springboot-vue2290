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


import com.dao.ShujileixingDao;
import com.entity.ShujileixingEntity;
import com.service.ShujileixingService;
import com.entity.vo.ShujileixingVO;
import com.entity.view.ShujileixingView;

@Service("shujileixingService")
public class ShujileixingServiceImpl extends ServiceImpl<ShujileixingDao, ShujileixingEntity> implements ShujileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShujileixingEntity> page = this.selectPage(
                new Query<ShujileixingEntity>(params).getPage(),
                new EntityWrapper<ShujileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShujileixingEntity> wrapper) {
		  Page<ShujileixingView> page =new Query<ShujileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShujileixingVO> selectListVO(Wrapper<ShujileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShujileixingVO selectVO(Wrapper<ShujileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShujileixingView> selectListView(Wrapper<ShujileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShujileixingView selectView(Wrapper<ShujileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
