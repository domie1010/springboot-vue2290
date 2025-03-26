package com.entity.vo;

import com.entity.JingjishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 图书馆书籍
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public class JingjishuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 文献类型
	 */
	
	private String booktype;
		
	/**
	 * 书籍类型
	 */
	
	private String shujileixing;
		
	/**
	 * 著者
	 */
	
	private String author;
		
	/**
	 * 出版年份
	 */
	
	private String chubanyear;
		
	/**
	 * 出版社
	 */
	
	private String chubanshe;
		
	/**
	 * 数源数据库
	 */
	
	private String sourceku;
		
	/**
	 * 封面
	 */
	
	private String cover;
		
	/**
	 * 来源
	 */
	
	private String laiyuan;
		
	/**
	 * 详细信息
	 */
	
	private String info;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：文献类型
	 */
	 
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	
	/**
	 * 获取：文献类型
	 */
	public String getBooktype() {
		return booktype;
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
	 * 设置：著者
	 */
	 
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * 获取：著者
	 */
	public String getAuthor() {
		return author;
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
	 * 设置：数源数据库
	 */
	 
	public void setSourceku(String sourceku) {
		this.sourceku = sourceku;
	}
	
	/**
	 * 获取：数源数据库
	 */
	public String getSourceku() {
		return sourceku;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	/**
	 * 获取：封面
	 */
	public String getCover() {
		return cover;
	}
				
	
	/**
	 * 设置：来源
	 */
	 
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
				
	
	/**
	 * 设置：详细信息
	 */
	 
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * 获取：详细信息
	 */
	public String getInfo() {
		return info;
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
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
