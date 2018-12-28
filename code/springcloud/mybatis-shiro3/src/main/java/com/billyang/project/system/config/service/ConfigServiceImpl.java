package com.billyang.project.system.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billyang.common.utils.StringUtils;
import com.billyang.project.system.config.domain.Config;
import com.billyang.project.system.config.mapper.ConfigMapper;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：ConfigServiceImpl   
* 类描述：   系统配置服务类
* 创建人：yangcan14944   
* 创建时间：2018-11-16 下午4:07:09   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 下午4:07:09   
* 修改备注：   
* @version    
*    
*/
@Service("configService")
public class ConfigServiceImpl implements IConfigService{
	@Autowired
	private ConfigMapper configMapper;
	
    /**
     * 根据键名查询参数配置信息
     * 
     * @param configName 参数名称
     * @return 参数键值
     */
    @Override
    public String selectConfigByKey(String configKey)
    {
        Config config = configMapper.selectConfigByKey(configKey);
        return StringUtils.isNotNull(config) ? config.getConfigValue() : "";
    }

}
