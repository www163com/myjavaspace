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
* ��Ŀ���ƣ�24-spring-boot-redis   
* �����ƣ�RedisTest   
* ��������   SpringData Redis����
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����2:33:29   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����2:33:29   
* �޸ı�ע��   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App24.class)
public class RedisTest {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	/**
	 * ����һ���ַ���
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key", "������ѧ��");
	}
	/**
	 * ��ȡһ���ַ���
	 */
	@Test
	public void testGet(){
		String value = (String) this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	/**
	 * ����Users������Ҫʹ��jdk���л���
	 */
	@Test
	public void testSetUsers(){
		Users users = new Users();
		users.setAge(20);
		users.setId(1);
		users.setName("������");
		//�����������л���
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", users);
	}
	/**
	 * ��ȡUsers������Ҫʹ��jdk���л���
	 */
	@Test
	public void testGetUsers(){
		//�����������л���
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users = (Users) this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
	/**
	 * ����JSON��ʽ��Users���� 
	 */
	@Test
	public void testSetUsersUseJson(){
		Users users = new Users();
		users.setAge(20);
		users.setId(1);
		users.setName("������");
		//�����������л���
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}
	/**
	 * ����JSON��ʽ��ȡUsers���� 
	 */
	@Test
	public void testGetUsersUseJson(){
		//�����������л���
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
		String json2 = "{\"id\":1,\"name\":\"�����\",\"age\":20}";
			try {
				Users user = mapper.readValue(json2, Users.class);
				System.out.println(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}