package com.billyang;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：28-springcloud-mq   
* 类名称：Receiver   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-12 上午11:36:17   
* 修改人：yangcan14944   
* 修改时间：2018-10-12 上午11:36:17   
* 修改备注：   消息接收者
* @version    
*    
*/
@Component
public class Receiver {
	@RabbitListener(queues="hello-queue")
	public void process(String msg){
		System.out.println("receiver:"+msg);
	}
}
