package com.billyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangcan14944
 * SpringBoot整合Servlet方式一
 * 
 * web.xml
 * <servlet>
 * 	<servlet-name>FirstServlet</srevlet-name>
 *  <servlet-class>com.billyang.servlet.FirstServlet</servlet-class>
 * </servlet>
 * 
 * <servlet-mapping>
 * 	<servlet-name>FirstServlet</srevlet-name>
 *  <url-mapping>/first</url-mapping>
 * </servlet-mapping>
 * 
 */
@WebServlet(name="FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("first servlet doget");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("first servlet dopost");
	}
}
