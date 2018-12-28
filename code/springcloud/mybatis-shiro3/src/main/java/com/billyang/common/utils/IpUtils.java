package com.billyang.common.utils;

import javax.servlet.http.HttpServletRequest;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：IpUtils   
* 类描述：   获取IP方法
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:35:41   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:35:41   
* 修改备注：   
* @version    
*    
*/
public class IpUtils {
	public static String getIpAddr(HttpServletRequest request){
		if(request == null){
			return "unkonwn";
		}
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
	}
}
