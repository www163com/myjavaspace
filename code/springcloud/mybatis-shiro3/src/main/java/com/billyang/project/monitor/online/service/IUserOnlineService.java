package com.billyang.project.monitor.online.service;

import com.billyang.project.monitor.online.domain.UserOnline;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：IUserOnlineService   
* 类描述：   在线用户服务层
* 创建人：yangcan14944   
* 创建时间：2018-11-23 上午10:36:42   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 上午10:36:42   
* 修改备注：   
* @version    
*    
*/
public interface IUserOnlineService {
	/**
	 * 通过会话序号查询信息
	 * @param SessionId 会话ID
	 * @return 在线用户信息
	 */
	public UserOnline selectOnlineById(String sessionId);
	/**
	 * 通过会话序号删除信息
	 * @param sessionId
	 */
	public void deleteOnlineById(String sessionId);

	/**
	 * 保存会话信息
	 * @param online
	 */
	public void saveOnline(UserOnline online);
}
