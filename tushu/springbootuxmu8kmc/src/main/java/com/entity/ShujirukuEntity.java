package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 书籍入库
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
@TableName("shujiruku")
public class ShujirukuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShujirukuEntity() {
		
	}
	
	public ShujirukuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 借阅号
	 */
					
	private String jieyuehao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：借阅号
	 */
	public void setJieyuehao(String jieyuehao) {
		this.jieyuehao = jieyuehao;
	}
	/**
	 * 获取：借阅号
	 */
	public String getJieyuehao() {
		return jieyuehao;
	}
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
