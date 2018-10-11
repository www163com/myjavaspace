package com.billyang.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.billyang.service.UsersService;

/**   
*    
* 项目名称：27-spring-boot-quartz   
* 类名称：QuartzDemo   
* 类描述：   job类
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:19:57   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:19:57   
* 修改备注：   
* @version    
*    
*/
public class QuartzDemo implements Job{
	@Autowired
	private UsersService usersService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Excute...."+new Date());
		this.usersService.addUser();
	}

}
