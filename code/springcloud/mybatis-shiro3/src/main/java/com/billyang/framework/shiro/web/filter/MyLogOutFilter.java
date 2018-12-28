package com.billyang.framework.shiro.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.billyang.common.constant.CommonConstants;
import com.billyang.common.utils.MessageUtils;
import com.billyang.common.utils.StringUtils;
import com.billyang.common.utils.SystemLogUtils;
import com.billyang.common.utils.security.ShiroUtils;
import com.billyang.project.system.user.domain.User;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：MyLogOutFilter   
* 类描述：   退出过滤器
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:20:34   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:20:34   
* 修改备注：   
* @version    
*    
*/
public class MyLogOutFilter extends LogoutFilter{
	private static final Logger log = LoggerFactory.getLogger(MyLogOutFilter.class);
	/**
	 * 退出后重定向的地址
	 */
	private String loginUrl;

	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		try{
			Subject subject = getSubject(request, response);
			String redirectUrl = getRedirectUrl(request, response, subject);
			try {
				User user = (User) ShiroUtils.getSubject().getPrincipal();
				if (StringUtils.isNotNull(user)) {
					String loginName = user.getLoginName();
					// 记录用户退出日志
					SystemLogUtils.log(loginName, CommonConstants.LOGOUT,
							MessageUtils.message("user.logout.success"));
				}
				// 退出登录
				subject.logout();
			} catch (SessionException ise) {
				log.error("logout fail.", ise);
			}
			issueRedirect(request, response, redirectUrl);
		} catch (Exception e) {
			log.debug("Encountered session exception during logout.  This can generally safely be ignored.",e);
		}
		return false;
	}


	@Override
	protected String getRedirectUrl(ServletRequest request,
			ServletResponse response, Subject subject) {
		String url = getLoginUrl();
		if(StringUtils.isNotEmpty(url)){
			return url;
		}
		return super.getRedirectUrl(request, response, subject);
	}


	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
}
