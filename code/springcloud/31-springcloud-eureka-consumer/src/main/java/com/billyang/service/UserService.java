package com.billyang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billyang.pojo.User;

/**   
*    
* ��Ŀ���ƣ�31-springcloud-eureka-consumer   
* �����ƣ�UserService   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-22 ����10:51:12   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-22 ����10:51:12   
* �޸ı�ע��   
* @version    
*    
*/
@Service
public class UserService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon���ؾ�����
	public List<User> getUsers(){
		//ѡ����õķ�������
		//ServiceInstance��װ�˷���Ļ�����Ϣ ��˿� IP��������
		ServiceInstance si = loadBalancerClient.choose("eureka-provider");
		//ƴ�ӷ��ʷ����URL
		StringBuffer sb = new StringBuffer();
		//http://localhost:9090/user
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user");
		//springMVC RestTemplate
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {};
		//ResponseEntity����װ�˷�����Ϣ
		ResponseEntity<List<User>> response = rt.exchange(sb.toString(), HttpMethod.GET,null,type);
		List<User> list = response.getBody();
		return list;
	}
	
}
