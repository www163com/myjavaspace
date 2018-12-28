package com.billyang.framework.shiro.session;

import java.util.Date;

import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.billyang.project.monitor.online.domain.OnlineSession;
import com.billyang.project.monitor.online.domain.UserOnline;
import com.billyang.project.monitor.online.service.IUserOnlineService;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：OnlineSessionDAO   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午4:37:44   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午4:37:44   
* 修改备注：   
* @version    
*    
*/
@Component
public class OnlineSessionDAO extends EnterpriseCacheSessionDAO {
	/**
	 * 同步session到数据库的周期 单位为毫秒（默认一分钟）
	 */
	@Value("${shiro.session.dbSyncPeriod}")
	private int dbSyscPeriod;
	/**
	 * 上次同步数据库的时间戳
	 */
	private static final String LAST_SYSC_DB_TIMESTAMP = OnlineSessionDAO.class.getName() + "LAST_SYSC_DB_TIMESTAMP";

	@Autowired
	private IUserOnlineService onlineService;

	public void syncToDb(OnlineSession onlineSession) {
		Date lastSyncTimestamp = (Date) onlineSession
				.getAttribute(LAST_SYSC_DB_TIMESTAMP);
		if (lastSyncTimestamp != null) {
			boolean needSync = true;
			long deltaTime = onlineSession.getLastAccessTime().getTime()
					- lastSyncTimestamp.getTime();
			if (deltaTime < dbSyscPeriod * 60 * 1000) {
				// 在同步更新频率之内 不更新
				needSync = false;
			}
			boolean isGuest = onlineSession.getUserId() == null
					|| onlineSession.getUserId() == 0L;
			if (isGuest == false && onlineSession.isAttributeChanged()) {
				needSync = true;
			}
			if (needSync == false) {
				return;
			}
		}
		onlineSession.setAttribute(LAST_SYSC_DB_TIMESTAMP,
				onlineSession.getLastAccessTime());
		// 更新完成后 重置标识
		if (onlineSession.isAttributeChanged()) {
			onlineSession.resetAttributeChanged();
		}
		onlineService.saveOnline(UserOnline.fromOnlineSession(onlineSession));
	}

	public OnlineSessionDAO() {
		super();
	}

	public OnlineSessionDAO(long expireTime) {
		super();
	}
}
