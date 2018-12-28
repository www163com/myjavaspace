package com.billyang.common.constant;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：ShiroConstants   
* 类描述：   shiro常用变量
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午2:06:32   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午2:06:32   
* 修改备注：   
* @version    
*    
*/
public interface ShiroConstants {
	/**
	 * 当前在线会话
	 */
	public String ONLINE_SESSION="online_session";
	/**
	 * 验证码
	 */
	public static final String CURRENT_VALIDATECODE="validateCode";
	/**
	 * 验证码错误
	 */
	public static final String CURRENT_ERROR="captchaError";
	/**
	 * 验证码key
	 */
	public static final String CURRENT_CAPTCHA = "captcha";
	/**
	 * 验证码开关
	 */
	public static final String CURRENT_EBABLED = "captchaEbabled";
	/**
	 * 验证码类型
	 */
	public static final String CURRENT_TYPE="captchaType";
}
