package com.dao;

import com.entity.ShujirukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShujirukuVO;
import com.entity.view.ShujirukuView;


/**
 * 书籍入库
 * 
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface ShujirukuDao extends BaseMapper<ShujirukuEntity> {
	
	List<ShujirukuVO> selectListVO(@Param("ew") Wrapper<ShujirukuEntity> wrapper);
	
	ShujirukuVO selectVO(@Param("ew") Wrapper<ShujirukuEntity> wrapper);
	
	List<ShujirukuView> selectListView(@Param("ew") Wrapper<ShujirukuEntity> wrapper);

	List<ShujirukuView> selectListView(Pagination page,@Param("ew") Wrapper<ShujirukuEntity> wrapper);
	
	ShujirukuView selectView(@Param("ew") Wrapper<ShujirukuEntity> wrapper);
	

}
