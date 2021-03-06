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
* 项目名称：24-spring-boot-redis   
* 类名称：RedisConfig   
* 类描述：   完成对redis整合时候的配置
* 创建人：yangcan14944   
* 创建时间：2018-10-10 下午2:11:26   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 下午2:11:26   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class RedisConfig {
	/*
	 *1.创建一个JedisPoolConfig对象，在该对象中完成一些连接池的配置 
	 *@ConfigurationProperties:会为前缀相同的内容创建一个实体
	 * */
	@Bean(name="jedisPoolConfig")
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig getJedisPoolConfig(){
		JedisPoolConfig config = new JedisPoolConfig();
//		//最大空闲数
//		config.setMaxIdle(10);
//		//最小空闲数
//		config.setMinIdle(5);
//		//最大连接数
//		config.setMaxTotal(20);
		System.out.println("默认值-Max-Idel:"+config.getMaxIdle());
		System.out.println("默认值-Min-Idel:"+config.getMinIdle());
		System.out.println("默认值-Max-Total:"+config.getMaxTotal());
		return config;
	}
	/*
	 * 2.创建JedisConnectionFactory：配置redis连接信息
	 * */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory getJedisConnectionFactory(@Qualifier("jedisPoolConfig")JedisPoolConfig config){
		System.out.println("设置完毕-Max-Idel:"+config.getMaxIdle());
		System.out.println("设置完毕-Min-Idel:"+config.getMinIdle());
		System.out.println("设置完毕-Max-Total:"+config.getMaxTotal());
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		//关联连接池的配置对象
		jedisConnectionFactory.setPoolConfig(config);
		jedisConnectionFactory.setDatabase(5);
		//配置redis信息
		//主机地址
//		jedisConnectionFactory.setHostName("127.0.0.1");
//		//redis端口
//		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}
	/*
	 * 3.创建RedisTemplate用于执行 redis的操作方法
	 * */
	@Bean
	public RedisTemplate<String,Object> getRedisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		//设置key序列化器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//设置value序列化器
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
