package com.billyang.project.system.config.mapper;

import com.billyang.project.system.config.domain.Config;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：ConfigMapper   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-16 下午4:12:45   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 下午4:12:45   
* 修改备注：   
* @version    
*    
*/
public interface ConfigMapper {
    /**
     * 根据键名查询参数配置信息
     * 
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    public Config selectConfigByKey(String configKey);
}
