package com.billyang.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：25-spring-boot-schedule   
* 类名称：ScheduleDemo   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午9:25:26   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午9:25:26   
* 修改备注：   
* @version    
*    
*/
@Component
public class ScheduleDemo {
	/*
	 * 定时任务方法
	 * @Scheduled:设置定时任务
	 * cron表达式。定时任务触发时间的一个字符串表达形式
	 * */
	@Scheduled(cron="0/2 * * * * ?")
	public void scheduledMethod(){
		System.out.println("定时器被触发:"+new Date());
	}
}
