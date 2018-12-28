package com.billyang.project.monitor.online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billyang.framework.shiro.session.OnlineSessionDAO;
import com.billyang.project.monitor.online.domain.UserOnline;
import com.billyang.project.monitor.online.mapper.UserOnlineMapper;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：UserOnlineServiceImpl   
* 类描述：   在线用户逻辑处理
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午4:29:48   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午4:29:48   
* 修改备注：   
* @version    
*    
*/
@Service("userOnlineService")
public class UserOnlineServiceImpl implements IUserOnlineService{
    @Autowired
    private UserOnlineMapper userOnlineDao;
	@Autowired
    private OnlineSessionDAO onlineSessionDAO;
	@Override
	public UserOnline selectOnlineById(String sessionId) {
		// TODO Auto-generated method stub
		return userOnlineDao.selectOnlineById(sessionId);
	}

	@Override
	public void deleteOnlineById(String sessionId) {
		// TODO Auto-generated method stub
		userOnlineDao.deleteOnlineById(sessionId);
	}

	@Override
	public void saveOnline(UserOnline online) {
		// TODO Auto-generated method stub
		userOnlineDao.saveOnline(online);
	}

}
