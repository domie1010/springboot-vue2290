package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingjishuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingjishuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingjishuView;


/**
 * 图书馆书籍
 *
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public interface JingjishuService extends IService<JingjishuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingjishuVO> selectListVO(Wrapper<JingjishuEntity> wrapper);
   	
   	JingjishuVO selectVO(@Param("ew") Wrapper<JingjishuEntity> wrapper);
   	
   	List<JingjishuView> selectListView(Wrapper<JingjishuEntity> wrapper);
   	
   	JingjishuView selectView(@Param("ew") Wrapper<JingjishuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingjishuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JingjishuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JingjishuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JingjishuEntity> wrapper);



}

