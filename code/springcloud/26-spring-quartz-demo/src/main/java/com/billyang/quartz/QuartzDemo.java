package com.billyang.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**   
*    
* 项目名称：26-spring-quartz-demo   
* 类名称：Quartz   
* 类描述：   定义任务类
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:00:19   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:00:19   
* 修改备注：   
* @version    
*    
*/
public class QuartzDemo implements Job {

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 * 任务被触发时执行的方法
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Excute..."+new Date());
	}
}
