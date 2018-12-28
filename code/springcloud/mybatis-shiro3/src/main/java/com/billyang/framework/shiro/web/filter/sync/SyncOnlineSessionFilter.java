package com.billyang.framework.shiro.web.filter.sync;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.billyang.common.constant.ShiroConstants;
import com.billyang.framework.shiro.session.OnlineSessionDAO;
import com.billyang.project.monitor.online.domain.OnlineSession;

public class SyncOnlineSessionFilter extends PathMatchingFilter{

	@Autowired
	private OnlineSessionDAO onlineSessionDAO;

	/* (non-Javadoc)
	 * @see org.apache.shiro.web.filter.PathMatchingFilter#preHandle(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 * 同步会话数据到db，一次请求最多同步一次 防止过多处理 需要放到shiro过滤器之前
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		OnlineSession session = (OnlineSession) request.getAttribute(ShiroConstants.ONLINE_SESSION);
		if(session!=null && session.getUserId()!= null && session.getStopTimestamp()==null){
			onlineSessionDAO.syncToDb(session);
		}
		return true;
	}
	
}
