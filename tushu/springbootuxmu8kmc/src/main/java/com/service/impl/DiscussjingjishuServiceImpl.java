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


import com.dao.DiscussjingjishuDao;
import com.entity.DiscussjingjishuEntity;
import com.service.DiscussjingjishuService;
import com.entity.vo.DiscussjingjishuVO;
import com.entity.view.DiscussjingjishuView;

@Service("discussjingjishuService")
public class DiscussjingjishuServiceImpl extends ServiceImpl<DiscussjingjishuDao, DiscussjingjishuEntity> implements DiscussjingjishuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjingjishuEntity> page = this.selectPage(
                new Query<DiscussjingjishuEntity>(params).getPage(),
                new EntityWrapper<DiscussjingjishuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjingjishuEntity> wrapper) {
		  Page<DiscussjingjishuView> page =new Query<DiscussjingjishuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjingjishuVO> selectListVO(Wrapper<DiscussjingjishuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjingjishuVO selectVO(Wrapper<DiscussjingjishuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjingjishuView> selectListView(Wrapper<DiscussjingjishuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjingjishuView selectView(Wrapper<DiscussjingjishuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
