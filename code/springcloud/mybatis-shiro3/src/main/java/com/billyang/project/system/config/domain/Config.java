package com.billyang.project.system.config.domain;

import com.billyang.framework.web.domain.BaseEntity;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：Config   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-16 下午4:09:44   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 下午4:09:44   
* 修改备注：   
* @version    
*    
*/
public class Config extends BaseEntity{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 参数主键 */
    private Integer configId;
    /** 参数名称 */
    private String configName;
    /** 参数键名 */
    private String configKey;
    /** 参数键值 */
    private String configValue;
    /** 系统内置（Y是 N否） */
    private String configType;
	public Integer getConfigId() {
		return configId;
	}
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getConfigType() {
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}
}
