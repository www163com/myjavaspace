package com.billyang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.billyang.quartz.QuartzDemo;

/**   
*    
* 项目名称：27-spring-boot-quartz   
* 类名称：QuartzConfig   
* 类描述：  Quartz配置类 
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:21:10   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:21:10   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class QuartzConfig {
	/*
	 * 1.创建job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		//关联自己的JOB类
		factory.setJobClass(QuartzDemo.class);
		return factory;
	}
	/*
	 * 2.创建trigger对象
	 */
//	 @Bean
//	 public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
//		 SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
//		 //关联jibdetail对象
//		 factory.setJobDetail(jobDetailFactoryBean.getObject());
//		 //该参数表示一个执行的毫秒数
//		 factory.setRepeatInterval(2000);
//		 factory.setRepeatCount(5);
//		 return factory;
//	 }
	/*
	 * Cron Triger
	 * */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		factory.setCronExpression("0/2 * * * * ?");
		return factory;
	}
	/*
	 * 
	 * 3.创建scheduler对象
	 * */
//	 @Bean
//	 public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
//		 SchedulerFactoryBean factory = new SchedulerFactoryBean();
//		 //关联trigger
//		 factory.setTriggers(cronTriggerFactoryBean.getObject());
//		 return factory;
//	 }
	 @Bean
	 public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
		 SchedulerFactoryBean factory = new SchedulerFactoryBean();
		 //关联trigger
		 factory.setTriggers(cronTriggerFactoryBean.getObject());
		 factory.setJobFactory(myAdaptableJobFactory);
		 return factory;
	 }
}
