package com.dao;

import com.entity.DiscussjingjishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjingjishuVO;
import com.entity.view.DiscussjingjishuView;


/**
 * jingjishu评论表
 * 
 * @author 
 * @email 
 * @date 2023-11-28 09:57:36
 */
public interface DiscussjingjishuDao extends BaseMapper<DiscussjingjishuEntity> {
	
	List<DiscussjingjishuVO> selectListVO(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
	
	DiscussjingjishuVO selectVO(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
	
	List<DiscussjingjishuView> selectListView(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);

	List<DiscussjingjishuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
	
	DiscussjingjishuView selectView(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
	

}
