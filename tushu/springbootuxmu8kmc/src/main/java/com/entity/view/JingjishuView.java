package com.entity.view;

import com.entity.JingjishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 图书馆书籍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
@TableName("jingjishu")
public class JingjishuView  extends JingjishuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingjishuView(){
	}
 
 	public JingjishuView(JingjishuEntity jingjishuEntity){
 	try {
			BeanUtils.copyProperties(this, jingjishuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
