package com.billyang.common.utils.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.billyang.project.system.user.domain.User;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：ShiroUtils   
* 类描述：   shiro工具类
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午2:11:01   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午2:11:01   
* 修改备注：   
* @version    
*    
*/
public class ShiroUtils {
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	public static User getUser(){
		return (User) getSubject().getPrincipal();
	}
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
	public static String getIp(){
		return getSubject().getSession().getHost();
	}
}
