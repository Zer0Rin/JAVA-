package com.entity.model;

import com.entity.WodegedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 我的歌单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public class WodegedanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
