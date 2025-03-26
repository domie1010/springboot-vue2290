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


import com.dao.ShujirukuDao;
import com.entity.ShujirukuEntity;
import com.service.ShujirukuService;
import com.entity.vo.ShujirukuVO;
import com.entity.view.ShujirukuView;

@Service("shujirukuService")
public class ShujirukuServiceImpl extends ServiceImpl<ShujirukuDao, ShujirukuEntity> implements ShujirukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShujirukuEntity> page = this.selectPage(
                new Query<ShujirukuEntity>(params).getPage(),
                new EntityWrapper<ShujirukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShujirukuEntity> wrapper) {
		  Page<ShujirukuView> page =new Query<ShujirukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShujirukuVO> selectListVO(Wrapper<ShujirukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShujirukuVO selectVO(Wrapper<ShujirukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShujirukuView> selectListView(Wrapper<ShujirukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShujirukuView selectView(Wrapper<ShujirukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
