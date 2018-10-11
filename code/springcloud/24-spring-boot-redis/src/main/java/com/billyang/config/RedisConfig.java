package com.billyang.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**   
*    
* ��Ŀ���ƣ�24-spring-boot-redis   
* �����ƣ�RedisConfig   
* ��������   ��ɶ�redis����ʱ�������
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����2:11:26   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����2:11:26   
* �޸ı�ע��   
* @version    
*    
*/
@Configuration
public class RedisConfig {
	/*
	 *1.����һ��JedisPoolConfig�����ڸö��������һЩ���ӳص����� 
	 *@ConfigurationProperties:��Ϊǰ׺��ͬ�����ݴ���һ��ʵ��
	 * */
	@Bean(name="jedisPoolConfig")
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig getJedisPoolConfig(){
		JedisPoolConfig config = new JedisPoolConfig();
//		//��������
//		config.setMaxIdle(10);
//		//��С������
//		config.setMinIdle(5);
//		//���������
//		config.setMaxTotal(20);
		System.out.println("Ĭ��ֵ-Max-Idel:"+config.getMaxIdle());
		System.out.println("Ĭ��ֵ-Min-Idel:"+config.getMinIdle());
		System.out.println("Ĭ��ֵ-Max-Total:"+config.getMaxTotal());
		return config;
	}
	/*
	 * 2.����JedisConnectionFactory������redis������Ϣ
	 * */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory getJedisConnectionFactory(@Qualifier("jedisPoolConfig")JedisPoolConfig config){
		System.out.println("�������-Max-Idel:"+config.getMaxIdle());
		System.out.println("�������-Min-Idel:"+config.getMinIdle());
		System.out.println("�������-Max-Total:"+config.getMaxTotal());
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		//�������ӳص����ö���
		jedisConnectionFactory.setPoolConfig(config);
		jedisConnectionFactory.setDatabase(5);
		//����redis��Ϣ
		//������ַ
//		jedisConnectionFactory.setHostName("127.0.0.1");
//		//redis�˿�
//		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}
	/*
	 * 3.����RedisTemplate����ִ�� redis�Ĳ�������
	 * */
	@Bean
	public RedisTemplate<String,Object> getRedisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		//����key���л���
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//����value���л���
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}