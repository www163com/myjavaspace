package com.billyang.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：SpringUtils   
* 类描述：   spring工具类，方便非spring管理环境中配置bean
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:50:14   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:50:14   
* 修改备注：   
* @version    
*    
*/
@Component
public final class SpringUtils implements BeanFactoryPostProcessor{

	private static ConfigurableListableBeanFactory beanFactory;
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringUtils.beanFactory = beanFactory;
	}
	/**
	 * @param name
	 * @return Object 根据名字返回bean的实例
	 * @throws BeansException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name)throws BeansException{
		return (T)beanFactory.getBean(name);
	}
	/**
	 * @param clz
	 * @return Object 根据类名获取bean实例
	 */
	public static <T> T getBean(Class<T> clz){
		T result = beanFactory.getBean(clz);
		return result;
	}
}
