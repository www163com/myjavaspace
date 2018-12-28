package com.billyang.common.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：LogUtils   
* 类描述：   处理并记录日志文件
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:31:08   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:31:08   
* 修改备注：   
* @version    
*    
*/
public class LogUtils {
	public static final Logger ERROR_LOG = LoggerFactory.getLogger("sys-error");
	public static final Logger ACCESS_LOG = LoggerFactory.getLogger("sys-access");
    /**
     * 记录访问日志 [username][jsessionid][ip][accept][UserAgent][url][params][Referer]
     *
     * @param request
     */
	public static void logAccess(HttpServletRequest request){
		String username = getUsername();
		String jsessionId = request.getRequestedSessionId();
		String ip = IpUtils.getIpAddr(request);
		String accept = request.getHeader("accept");
		String userAgent = request.getHeader("User-Agent");
		String url = request.getRequestURI();
		String params = getParams(request);
        StringBuilder s = new StringBuilder();
        s.append(getBlock(username));
        s.append(getBlock(jsessionId));
        s.append(getBlock(ip));
        s.append(getBlock(accept));
        s.append(getBlock(userAgent));
        s.append(getBlock(url));
        s.append(getBlock(params));
        s.append(getBlock(request.getHeader("Referer")));
        getAccessLog().info(s.toString());
	}
	private static Logger getAccessLog() {
		return ACCESS_LOG;
	}
	private static String getParams(HttpServletRequest request) {
		Map<String,String[]> params = request.getParameterMap();
		return JSON.toJSONString(params);
	}
	private static String getUsername() {
		// TODO Auto-generated method stub
		return (String)SecurityUtils.getSubject().getPrincipal();
	}
	public static String getBlock(Object msg){
		if(msg == null){
			return "";
		}
		return "["+msg.toString()+"]";
	}
}
