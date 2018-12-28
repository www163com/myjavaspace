package com.billyang.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.billyang.common.utils.security.ShiroUtils;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：SystemLogUtils   
* 类描述：   记录用户日志信息
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:27:20   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:27:20   
* 修改备注：   
* @version    
*    
*/
public class SystemLogUtils {
	private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");
	public static void log(String username,String status,String msg,Object... args){
		StringBuilder s = new StringBuilder();
		s.append(LogUtils.getBlock(ShiroUtils.getIp()));
        s.append(LogUtils.getBlock(username));
        s.append(LogUtils.getBlock(status));
        s.append(LogUtils.getBlock(msg));
	}
}
