package com.billyang.project.monitor.online.domain;

import java.util.Date;

import com.billyang.framework.web.domain.BaseEntity;
import com.billyang.project.monitor.online.domain.OnlineSession.OnlineStatus;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：UserOnline   
* 类描述：   当前在线会话 sys_user_online
* 创建人：yangcan14944   
* 创建时间：2018-11-23 上午10:38:32   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 上午10:38:32   
* 修改备注：   
* @version    
*    
*/
public class UserOnline extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户会话ID
	 */
	private String sessionId;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 登录名称
	 */
	private String loginName;
	/**
	 * 登录IP
	 */
	private String ipaddr;
	/**
	 * 浏览器
	 */
	private String browser;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * session创建时间
	 */
	private Date startTimestamp;
	/**
	 * session最后访问时间
	 */
	private Date lastAccessTime;
	/**
	 * 超时时间 单位为分钟
	 */
	private Long expireTime;
	/**
	 * 在线状态
	 */
	private OnlineStatus status = OnlineStatus.on_line;
	/**
	 * 备份当前用户会话
	 */
	private OnlineSession session;
	public static final UserOnline fromOnlineSession(OnlineSession session){
		UserOnline online = new UserOnline();
        online.setSessionId(String.valueOf(session.getId()));
        online.setDeptName(session.getDeptName());
        online.setLoginName(session.getLoginName());
        online.setStartTimestamp(session.getStartTimestamp());
        online.setLastAccessTime(session.getLastAccessTime());
        online.setExpireTime(session.getTimeout());
        online.setIpaddr(session.getHost());
        online.setBrowser(session.getBrowser());
        online.setOs(session.getOs());
        online.setStatus(session.getStatus());
        online.setSession(session);
		return online;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Date getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public Long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	public OnlineStatus getStatus() {
		return status;
	}
	public void setStatus(OnlineStatus status) {
		this.status = status;
	}
	public OnlineSession getSession() {
		return session;
	}
	public void setSession(OnlineSession session) {
		this.session = session;
	}
    @Override
    public String toString()
    {
        return "UserOnline [sessionId=" + sessionId + ", deptName=" + deptName + ", loginName=" + loginName
                + ", ipaddr=" + ipaddr + ", browser=" + browser + ", os=" + os + ", startTimestamp=" + startTimestamp
                + ", lastAccessTime=" + lastAccessTime + ", expireTime=" + expireTime + ", status=" + status
                + ", session=" + session + "]";
    }
}
