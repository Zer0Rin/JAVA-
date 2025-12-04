package com.entity.vo;

import com.entity.ZaixianshitingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 在线试听
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
public class ZaixianshitingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 歌曲分类
	 */
	
	private String gequfenlei;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 标签
	 */
	
	private String biaoqian;
		
	/**
	 * 歌手
	 */
	
	private String singer;
		
	/**
	 * 语言
	 */
	
	private String yuyan;
		
	/**
	 * 专辑
	 */
	
	private String zhuanji;
		
	/**
	 * 音乐播放
	 */
	
	private String songfile;
		
	/**
	 * 价格
	 */
	
	private Double jiage;
		
	/**
	 * 版权方
	 */
	
	private String banquanfang;
		
	/**
	 * 歌词大意
	 */
	
	private String gecidayi;
		
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
	 * 设置：标签
	 */
	 
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	
	/**
	 * 获取：标签
	 */
	public String getBiaoqian() {
		return biaoqian;
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
	 * 设置：音乐播放
	 */
	 
	public void setSongfile(String songfile) {
		this.songfile = songfile;
	}
	
	/**
	 * 获取：音乐播放
	 */
	public String getSongfile() {
		return songfile;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getJiage() {
		return jiage;
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
