package com.billyang;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**   
*    
* 项目名称：28-springcloud-mq   
* 类名称：QueueConfig   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-12 上午11:29:49   
* 修改人：yangcan14944   
* 修改时间：2018-10-12 上午11:29:49   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class QueueConfig {
	/**
	 * 创建队列
	 * @return
	 */
	@Bean
	public Queue createQueue(){
		return new Queue("hello-queue");
	}
}
