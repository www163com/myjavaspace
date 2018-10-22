package com.billyang;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：28-springcloud-mq   
* 类名称：Sender   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-12 上午11:32:44   
* 修改人：yangcan14944   
* 修改时间：2018-10-12 上午11:32:44   
* 修改备注：   消息发送者
* @version    
*    
*/
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	public void send(String msg){
		//参数一：队列名称
		//参数二：发送的消息
		this.rabbitAmqpTemplate.convertAndSend("hello-queue",msg);
	}
}
