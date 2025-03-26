package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjingjishuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjingjishuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjingjishuView;


/**
 * jingjishu评论表
 *
 * @author 
 * @email 
 * @date 2023-11-28 09:57:36
 */
public interface DiscussjingjishuService extends IService<DiscussjingjishuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjingjishuVO> selectListVO(Wrapper<DiscussjingjishuEntity> wrapper);
   	
   	DiscussjingjishuVO selectVO(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
   	
   	List<DiscussjingjishuView> selectListView(Wrapper<DiscussjingjishuEntity> wrapper);
   	
   	DiscussjingjishuView selectView(@Param("ew") Wrapper<DiscussjingjishuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjingjishuEntity> wrapper);
   	

}

