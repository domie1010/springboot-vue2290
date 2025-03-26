package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShujileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShujileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujileixingView;


/**
 * 书籍类型
 *
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface ShujileixingService extends IService<ShujileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShujileixingVO> selectListVO(Wrapper<ShujileixingEntity> wrapper);
   	
   	ShujileixingVO selectVO(@Param("ew") Wrapper<ShujileixingEntity> wrapper);
   	
   	List<ShujileixingView> selectListView(Wrapper<ShujileixingEntity> wrapper);
   	
   	ShujileixingView selectView(@Param("ew") Wrapper<ShujileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShujileixingEntity> wrapper);
   	

}

