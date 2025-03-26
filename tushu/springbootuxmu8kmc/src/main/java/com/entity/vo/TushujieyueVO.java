package com.entity.vo;

import com.entity.TushujieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 图书借阅
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
public class TushujieyueVO  implements Serializable {
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
	 * 封面
	 */
	
	private String cover;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 身份
	 */
	
	private String shenfen;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 借阅时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jieyueshijian;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
				
	
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
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：身份
	 */
	 
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	
	/**
	 * 获取：身份
	 */
	public String getShenfen() {
		return shenfen;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：借阅时间
	 */
	 
	public void setJieyueshijian(Date jieyueshijian) {
		this.jieyueshijian = jieyueshijian;
	}
	
	/**
	 * 获取：借阅时间
	 */
	public Date getJieyueshijian() {
		return jieyueshijian;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
			
}
