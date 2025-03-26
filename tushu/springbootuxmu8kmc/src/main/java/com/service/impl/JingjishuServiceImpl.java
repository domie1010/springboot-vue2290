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


import com.dao.JingjishuDao;
import com.entity.JingjishuEntity;
import com.service.JingjishuService;
import com.entity.vo.JingjishuVO;
import com.entity.view.JingjishuView;

@Service("jingjishuService")
public class JingjishuServiceImpl extends ServiceImpl<JingjishuDao, JingjishuEntity> implements JingjishuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingjishuEntity> page = this.selectPage(
                new Query<JingjishuEntity>(params).getPage(),
                new EntityWrapper<JingjishuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingjishuEntity> wrapper) {
		  Page<JingjishuView> page =new Query<JingjishuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingjishuVO> selectListVO(Wrapper<JingjishuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingjishuVO selectVO(Wrapper<JingjishuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingjishuView> selectListView(Wrapper<JingjishuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingjishuView selectView(Wrapper<JingjishuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JingjishuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JingjishuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JingjishuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
