package com.entity.view;

import com.entity.YinlebofangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 音乐播放
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-12-03 09:16:23
 */
@TableName("yinlebofang")
public class YinlebofangView  extends YinlebofangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinlebofangView(){
	}
 
 	public YinlebofangView(YinlebofangEntity yinlebofangEntity){
 	try {
			BeanUtils.copyProperties(this, yinlebofangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
