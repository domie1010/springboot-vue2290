package com.dao;

import com.entity.JingjishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingjishuVO;
import com.entity.view.JingjishuView;


/**
 * 图书馆书籍
 * 
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface JingjishuDao extends BaseMapper<JingjishuEntity> {
	
	List<JingjishuVO> selectListVO(@Param("ew") Wrapper<JingjishuEntity> wrapper);
	
	JingjishuVO selectVO(@Param("ew") Wrapper<JingjishuEntity> wrapper);
	
	List<JingjishuView> selectListView(@Param("ew") Wrapper<JingjishuEntity> wrapper);

	List<JingjishuView> selectListView(Pagination page,@Param("ew") Wrapper<JingjishuEntity> wrapper);
	
	JingjishuView selectView(@Param("ew") Wrapper<JingjishuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingjishuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingjishuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingjishuEntity> wrapper);



}
