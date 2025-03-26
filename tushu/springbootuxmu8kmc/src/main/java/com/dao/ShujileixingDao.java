package com.dao;

import com.entity.ShujileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShujileixingVO;
import com.entity.view.ShujileixingView;


/**
 * 书籍类型
 * 
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface ShujileixingDao extends BaseMapper<ShujileixingEntity> {
	
	List<ShujileixingVO> selectListVO(@Param("ew") Wrapper<ShujileixingEntity> wrapper);
	
	ShujileixingVO selectVO(@Param("ew") Wrapper<ShujileixingEntity> wrapper);
	
	List<ShujileixingView> selectListView(@Param("ew") Wrapper<ShujileixingEntity> wrapper);

	List<ShujileixingView> selectListView(Pagination page,@Param("ew") Wrapper<ShujileixingEntity> wrapper);
	
	ShujileixingView selectView(@Param("ew") Wrapper<ShujileixingEntity> wrapper);
	

}
