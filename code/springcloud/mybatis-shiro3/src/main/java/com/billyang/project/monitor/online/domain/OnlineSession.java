package com.billyang.project.monitor.online.domain;

import org.apache.shiro.session.mgt.SimpleSession;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：OnlineSession   
* 类描述：   在线用户会话属性
* 创建人：yangcan14944   
* 创建时间：2018-11-23 上午10:42:53   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 上午10:42:53   
* 修改备注：   
* @version    
*    
*/
public class OnlineSession extends SimpleSession{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名称
	 */
	private String loginName;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 登录IP地址
	 */
	private String host;
	/**
	 * 浏览器类型
	 */
	private String browser;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 在线状态
	 */
	private OnlineStatus status = OnlineStatus.on_line;
	/**
	 * 属性是否改变，优化session数据童年公布
	 */
	private transient boolean attributeChanged = false;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
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
	public OnlineStatus getStatus() {
		return status;
	}
	public void setStatus(OnlineStatus status) {
		this.status = status;
	}
	public void markAttributeChanged(){
		this.attributeChanged = true;
	}
	public void resetAttributeChanged(){
		this.attributeChanged = false;
	}
	public boolean isAttributeChanged(){
		return this.attributeChanged;
	}
	public void setAttribute(Object key,Object value){
		super.setAttribute(key, value);
	}
	public Object removeAttribute(Object key){
		return super.removeAttribute(key);
	}
	public static enum OnlineStatus{
		on_line("在线"),off_line("离线");
		private final String info;
		private OnlineStatus(String info){
			this.info = info;
		}
		public String getInfo(){
			return info;
		}
	}
}
