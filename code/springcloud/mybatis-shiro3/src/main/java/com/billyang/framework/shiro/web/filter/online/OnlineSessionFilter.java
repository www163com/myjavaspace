package com.billyang.framework.shiro.web.filter.online;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.billyang.common.constant.ShiroConstants;
import com.billyang.common.utils.security.ShiroUtils;
import com.billyang.framework.shiro.session.OnlineSessionDAO;
import com.billyang.project.monitor.online.domain.OnlineSession;
import com.billyang.project.monitor.online.domain.OnlineSession.OnlineStatus;
import com.billyang.project.system.user.domain.User;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：OnlineSessionFilter   
* 类描述：   自定义访问控制
* 创建人：yangcan14944   
* 创建时间：2018-11-23 上午10:29:42   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 上午10:29:42   
* 修改备注：   
* @version    
*    
*/
public class OnlineSessionFilter extends AccessControlFilter{
	@Value("${shiro.user.loginUrl}")
	private String loginUrl;
	@Autowired
	private OnlineSessionDAO onlineSessionDAO;
	/* (non-Javadoc)
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 * 表示是否可以访问；mappedValue就是【urls】配置中拦截器参数部分，如果允许访问返回true否则返回false
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
		if(subject==null||subject.getSession()==null){
			return true;
		}
		Session session = onlineSessionDAO.readSession(subject.getSession().getId());
		if(session!=null && session instanceof OnlineSession){
			OnlineSession onlineSession = (OnlineSession)session;
			request.setAttribute(ShiroConstants.ONLINE_SESSION, onlineSession);
			// 把user对象设置进去
			boolean isGuest = onlineSession.getUserId()==null || onlineSession.getUserId()==0L;
			if(isGuest==true){
				User user = ShiroUtils.getUser();
				if(user!=null){
					onlineSession.setUserId(user.getUserId());
					onlineSession.setUserId(user.getUserId());
                    onlineSession.setLoginName(user.getLoginName());
                   // onlineSession.setDeptName(user.getDept().getDeptName());
                    onlineSession.markAttributeChanged();
				}
			}
			if(onlineSession.getStatus()==OnlineStatus.off_line){
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.web.filter.AccessControlFilter#onAccessDenied(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 *表示当访问拒绝时是否处理了，如果返回true表示需要继续处理，如果返回false表示该拦截器实例已经处理了，直接返回即可
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		Subject subject = getSubject(request, response);
		if(subject != null){
			subject.logout();
		}
		saveRequestAndRedirectToLogin(request, response);
		return false;
	}

	@Override
	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		WebUtils.issueRedirect(request, response, loginUrl);
	}

}
