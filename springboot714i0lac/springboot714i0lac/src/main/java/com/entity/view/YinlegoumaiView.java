package com.entity.view;

import com.entity.YinlegoumaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 音乐购买
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
@TableName("yinlegoumai")
public class YinlegoumaiView  extends YinlegoumaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinlegoumaiView(){
	}
 
 	public YinlegoumaiView(YinlegoumaiEntity yinlegoumaiEntity){
 	try {
			BeanUtils.copyProperties(this, yinlegoumaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
