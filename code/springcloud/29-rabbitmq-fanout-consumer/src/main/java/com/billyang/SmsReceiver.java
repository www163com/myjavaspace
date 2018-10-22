package com.billyang;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**   
*    
* 项目名称：29-rabbitmq-fanout-consumer   
* 类名称：SmsReceiver   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-16 上午11:08:06   
* 修改人：yangcan14944   
* 修改时间：2018-10-16 上午11:08:06   
* 修改备注：   
* @version    
*    
*/
/**
* 消息接收者
* @author Administrator
* @RabbitListener bindings:绑定队列
* @QueueBinding value:绑定队列的名称
* exchange:配置交换器
* @Queue value:配置队列名称
* autoDelete:是否是一个可删除的临时队列
** @Exchange value:为交换器起个名称
* type:指定具体的交换器类型
*/
@Component
@RabbitListener(bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.sms}",autoDelete="false"),
                         exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.FANOUT)))
public class SmsReceiver {
	@RabbitHandler
	public void peocess(String msg){
		System.out.println("Sms......receiver: "+msg);
	}
}
