package com.entity.vo;

import com.entity.YinyuexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 音乐信息
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
public class YinyuexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 作者
	 */
	
	private String zuozhe;
		
	/**
	 * 收藏数
	 */
	
	private Integer shoucang;
		
	/**
	 * 分享数
	 */
	
	private Integer share;
		
	/**
	 * 评论数
	 */
	
	private Integer pinglun;
		
	/**
	 * 播放数
	 */
	
	private Integer bofang;
		
	/**
	 * 歌曲列表数
	 */
	
	private Integer gqlb;
		
	/**
	 * 详情地址
	 */
	
	private String xqdz;
		
	/**
	 * 介绍
	 */
	
	private String jieshao;
		
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
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：作者
	 */
	 
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setShoucang(Integer shoucang) {
		this.shoucang = shoucang;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getShoucang() {
		return shoucang;
	}
				
	
	/**
	 * 设置：分享数
	 */
	 
	public void setShare(Integer share) {
		this.share = share;
	}
	
	/**
	 * 获取：分享数
	 */
	public Integer getShare() {
		return share;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setPinglun(Integer pinglun) {
		this.pinglun = pinglun;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getPinglun() {
		return pinglun;
	}
				
	
	/**
	 * 设置：播放数
	 */
	 
	public void setBofang(Integer bofang) {
		this.bofang = bofang;
	}
	
	/**
	 * 获取：播放数
	 */
	public Integer getBofang() {
		return bofang;
	}
				
	
	/**
	 * 设置：歌曲列表数
	 */
	 
	public void setGqlb(Integer gqlb) {
		this.gqlb = gqlb;
	}
	
	/**
	 * 获取：歌曲列表数
	 */
	public Integer getGqlb() {
		return gqlb;
	}
				
	
	/**
	 * 设置：详情地址
	 */
	 
	public void setXqdz(String xqdz) {
		this.xqdz = xqdz;
	}
	
	/**
	 * 获取：详情地址
	 */
	public String getXqdz() {
		return xqdz;
	}
				
	
	/**
	 * 设置：介绍
	 */
	 
	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}
	
	/**
	 * 获取：介绍
	 */
	public String getJieshao() {
		return jieshao;
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
