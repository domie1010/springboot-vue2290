package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShujirukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShujirukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujirukuView;


/**
 * 书籍入库
 *
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface ShujirukuService extends IService<ShujirukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShujirukuVO> selectListVO(Wrapper<ShujirukuEntity> wrapper);
   	
   	ShujirukuVO selectVO(@Param("ew") Wrapper<ShujirukuEntity> wrapper);
   	
   	List<ShujirukuView> selectListView(Wrapper<ShujirukuEntity> wrapper);
   	
   	ShujirukuView selectView(@Param("ew") Wrapper<ShujirukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShujirukuEntity> wrapper);
   	

}

