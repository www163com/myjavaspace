package com.billyang.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**   
*    
* 项目名称：26-spring-quartz-demo   
* 类名称：QuartzMain   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:01:58   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:01:58   
* 修改备注：   
* @version    
*    
*/
public class QuartzMain {
	public static void main(String[] args) throws SchedulerException {
		//1.创建job对象：你要做什么事
		JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();
		/*
		 * 简单的trigger触发时间：通过Quartz提供的一些方法 来完成简单的重复调用
		 * cron Trigger：按照Cron表达式来给定触发时间
		 * */
		//2.创建trigger对象：在什么时间做
		//Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2)).build();
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
		//3.创建Scheduled对象：在什么时间做什么事
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		//启动
		scheduler.start();
	}
}
