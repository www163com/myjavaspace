package com.billyang.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yangcan14944 SpringBoot整合listener方式二
 * 
 *         <listener>
 *         <listener-class>com.billyang.listener.FirstListener</listener-class>
 *         </listener>
 */
public class SecondListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("second listener .....init......");

	}
}
