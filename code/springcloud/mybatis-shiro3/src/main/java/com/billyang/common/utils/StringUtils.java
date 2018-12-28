package com.billyang.common.utils;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：StringUtils   
* 类描述：   字符串处理工具类
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午11:06:41   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午11:06:41   
* 修改备注：   
* @version    
*    
*/
public class StringUtils {
	private static final String NULLSTR="";
	/**
	 * 判断字符串是否为空串
	 * @param str
	 * @return true:字符串为空 false:非空
	 */
	public static boolean isEmpty(String str){
		return isNull(str)||NULLSTR.equals(str);
	}
	/**
	 * 判断对象是否为空
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object){
		return object == null;
	}
	
	/**
	 * 判断对象是否为空
	 * @param object
	 * @return
	 */
	public static boolean isNotNull(Object object){
		return !isNull(object);
	}
	/**
	 * 判断一个字符串是否为非空串
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
}