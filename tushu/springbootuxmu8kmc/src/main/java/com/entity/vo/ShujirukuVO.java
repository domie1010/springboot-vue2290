package com.entity.vo;

import com.entity.ShujirukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 书籍入库
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public class ShujirukuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 书名
	 */
	
	private String bookname;
		
	/**
	 * 书籍类型
	 */
	
	private String shujileixing;
		
	/**
	 * 出版社
	 */
	
	private String chubanshe;
		
	/**
	 * 出版年份
	 */
	
	private String chubanyear;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 入库登记
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date rukudengji;
		
	/**
	 * 入库人
	 */
	
	private String rukuren;
				
	
	/**
	 * 设置：书名
	 */
	 
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	/**
	 * 获取：书名
	 */
	public String getBookname() {
		return bookname;
	}
				
	
	/**
	 * 设置：书籍类型
	 */
	 
	public void setShujileixing(String shujileixing) {
		this.shujileixing = shujileixing;
	}
	
	/**
	 * 获取：书籍类型
	 */
	public String getShujileixing() {
		return shujileixing;
	}
				
	
	/**
	 * 设置：出版社
	 */
	 
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	/**
	 * 获取：出版社
	 */
	public String getChubanshe() {
		return chubanshe;
	}
				
	
	/**
	 * 设置：出版年份
	 */
	 
	public void setChubanyear(String chubanyear) {
		this.chubanyear = chubanyear;
	}
	
	/**
	 * 获取：出版年份
	 */
	public String getChubanyear() {
		return chubanyear;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：入库登记
	 */
	 
	public void setRukudengji(Date rukudengji) {
		this.rukudengji = rukudengji;
	}
	
	/**
	 * 获取：入库登记
	 */
	public Date getRukudengji() {
		return rukudengji;
	}
				
	
	/**
	 * 设置：入库人
	 */
	 
	public void setRukuren(String rukuren) {
		this.rukuren = rukuren;
	}
	
	/**
	 * 获取：入库人
	 */
	public String getRukuren() {
		return rukuren;
	}
			
}
