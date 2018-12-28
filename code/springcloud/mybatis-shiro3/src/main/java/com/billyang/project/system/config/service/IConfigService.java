package com.billyang.project.system.config.service;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：IConfigService   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-16 下午4:08:23   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 下午4:08:23   
* 修改备注：   
* @version    
*    
*/
public interface IConfigService {
	 public String selectConfigByKey(String configKey);
}
