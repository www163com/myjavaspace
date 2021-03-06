package com.billyang.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：27-spring-boot-quartz   
* 类名称：MyAdaptableJobFactory   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:43:58   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:43:58   
* 修改备注：   
* @version    
*    
*/
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
	//AutowireCapableBeanFactory 可以将一个对象添加到springIOC容器中，并且完成该对象注入
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle)
			throws Exception {
		/*
		 * 该方法需要将实例化的任务对象手动添加到SpringIOC容器中，并且完成对象注入
		 * */
		Object object =  super.createJobInstance(bundle);
		//将obj对象添加到springioc容器中。并且完成注入
		this.autowireCapableBeanFactory.autowireBean(object);
		return object;
	}

}
