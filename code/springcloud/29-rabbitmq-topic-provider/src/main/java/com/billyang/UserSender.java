package com.billyang;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**   
*    
* 项目名称：29-rabbitmq-direct-provider   
* 类名称：Sender   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-12 下午2:43:45   
* 修改人：yangcan14944   
* 修改时间：2018-10-12 下午2:43:45   
* 修改备注：   
* @version    
*    
*/
@Component
public class UserSender {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String msg){
		//参数一：交换器名称
		//参数二：路由键
		//参数三：发送的消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.debug", "user.log.debug...."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.info", "user.log.info...."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.warn", "user.log.warn...."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.error", "user.log.error...."+msg);
	}
}
