package com.billyang.common.utils;

import org.springframework.context.MessageSource;

import com.billyang.common.utils.spring.SpringUtils;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：MessageUtils   
* 类描述：获取i18n资源文件   
* 创建人：yangcan14944   
* 创建时间：2018-11-23 下午3:48:24   
* 修改人：yangcan14944   
* 修改时间：2018-11-23 下午3:48:24   
* 修改备注：   
* @version    
*    
*/
public class MessageUtils {
	public static String message(String code,Object... args ){
		MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
		return messageSource.getMessage(code, args,null);
	}
}
