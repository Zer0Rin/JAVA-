package com.entity.view;

import com.entity.ZaixianshitingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 在线试听
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-12-03 09:16:22
 */
@TableName("zaixianshiting")
public class ZaixianshitingView  extends ZaixianshitingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianshitingView(){
	}
 
 	public ZaixianshitingView(ZaixianshitingEntity zaixianshitingEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianshitingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
