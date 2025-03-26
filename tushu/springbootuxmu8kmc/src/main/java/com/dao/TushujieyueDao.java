package com.dao;

import com.entity.TushujieyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushujieyueVO;
import com.entity.view.TushujieyueView;


/**
 * 图书借阅
 * 
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface TushujieyueDao extends BaseMapper<TushujieyueEntity> {
	
	List<TushujieyueVO> selectListVO(@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	
	TushujieyueVO selectVO(@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	
	List<TushujieyueView> selectListView(@Param("ew") Wrapper<TushujieyueEntity> wrapper);

	List<TushujieyueView> selectListView(Pagination page,@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	
	TushujieyueView selectView(@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TushujieyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TushujieyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TushujieyueEntity> wrapper);



}
