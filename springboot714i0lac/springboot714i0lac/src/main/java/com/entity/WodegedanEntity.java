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
 * 我的歌单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
@TableName("wodegedan")
public class WodegedanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WodegedanEntity() {
		
	}
	
	public WodegedanEntity(T t) {
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
	 * 歌单名称
	 */
					
	private String gedanmingcheng;
	
	/**
	 * 歌名
	 */
					
	private String songname;
	
	/**
	 * 歌曲分类
	 */
					
	private String gequfenlei;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 歌手
	 */
					
	private String singer;
	
	/**
	 * 音乐
	 */
					
	private String songfile;
	
	/**
	 * 专辑
	 */
					
	private String zhuanji;
	
	/**
	 * 语言
	 */
					
	private String yuyan;
	
	/**
	 * 版权方
	 */
					
	private String banquanfang;
	
	/**
	 * 歌词大意
	 */
					
	private String gecidayi;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
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
	 * 设置：歌单名称
	 */
	public void setGedanmingcheng(String gedanmingcheng) {
		this.gedanmingcheng = gedanmingcheng;
	}
	/**
	 * 获取：歌单名称
	 */
	public String getGedanmingcheng() {
		return gedanmingcheng;
	}
	/**
	 * 设置：歌名
	 */
	public void setSongname(String songname) {
		this.songname = songname;
	}
	/**
	 * 获取：歌名
	 */
	public String getSongname() {
		return songname;
	}
	/**
	 * 设置：歌曲分类
	 */
	public void setGequfenlei(String gequfenlei) {
		this.gequfenlei = gequfenlei;
	}
	/**
	 * 获取：歌曲分类
	 */
	public String getGequfenlei() {
		return gequfenlei;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：歌手
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
	/**
	 * 获取：歌手
	 */
	public String getSinger() {
		return singer;
	}
	/**
	 * 设置：音乐
	 */
	public void setSongfile(String songfile) {
		this.songfile = songfile;
	}
	/**
	 * 获取：音乐
	 */
	public String getSongfile() {
		return songfile;
	}
	/**
	 * 设置：专辑
	 */
	public void setZhuanji(String zhuanji) {
		this.zhuanji = zhuanji;
	}
	/**
	 * 获取：专辑
	 */
	public String getZhuanji() {
		return zhuanji;
	}
	/**
	 * 设置：语言
	 */
	public void setYuyan(String yuyan) {
		this.yuyan = yuyan;
	}
	/**
	 * 获取：语言
	 */
	public String getYuyan() {
		return yuyan;
	}
	/**
	 * 设置：版权方
	 */
	public void setBanquanfang(String banquanfang) {
		this.banquanfang = banquanfang;
	}
	/**
	 * 获取：版权方
	 */
	public String getBanquanfang() {
		return banquanfang;
	}
	/**
	 * 设置：歌词大意
	 */
	public void setGecidayi(String gecidayi) {
		this.gecidayi = gecidayi;
	}
	/**
	 * 获取：歌词大意
	 */
	public String getGecidayi() {
		return gecidayi;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
