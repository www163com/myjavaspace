package com.billyang.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billyang.App24;
import com.billyang.pojo.Users;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**   
*    
* 项目名称：24-spring-boot-redis   
* 类名称：RedisTest   
* 类描述：   SpringData Redis测试
* 创建人：yangcan14944   
* 创建时间：2018-10-10 下午2:33:29   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 下午2:33:29   
* 修改备注：   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App24.class)
public class RedisTest {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key", "北京尚学堂");
	}
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String) this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	/**
	 * 添加Users对象，需要使用jdk序列化器
	 */
	@Test
	public void testSetUsers(){
		Users users = new Users();
		users.setAge(20);
		users.setId(1);
		users.setName("张三丰");
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", users);
	}
	/**
	 * 获取Users对象，需要使用jdk序列化器
	 */
	@Test
	public void testGetUsers(){
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users = (Users) this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
	/**
	 * 基于JSON格式存Users对象 
	 */
	@Test
	public void testSetUsersUseJson(){
		Users users = new Users();
		users.setAge(20);
		users.setId(1);
		users.setName("李三丰");
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}
	/**
	 * 基于JSON格式获取Users对象 
	 */
	@Test
	public void testGetUsersUseJson(){
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(users);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		String json2 = "{\"id\":1,\"name\":\"李五丰\",\"age\":20}";
			try {
				Users user = mapper.readValue(json2, Users.class);
				System.out.println(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
