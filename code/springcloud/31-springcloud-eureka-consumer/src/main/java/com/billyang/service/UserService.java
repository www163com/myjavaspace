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
* 项目名称：31-springcloud-eureka-consumer   
* 类名称：UserService   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-22 上午10:51:12   
* 修改人：yangcan14944   
* 修改时间：2018-10-22 上午10:51:12   
* 修改备注：   
* @version    
*    
*/
@Service
public class UserService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon负载均衡器
	public List<User> getUsers(){
		//选择调用的服务名称
		//ServiceInstance封装了服务的基本信息 如端口 IP服务名称
		ServiceInstance si = loadBalancerClient.choose("eureka-provider");
		//拼接访问服务的URL
		StringBuffer sb = new StringBuffer();
		//http://localhost:9090/user
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user");
		//springMVC RestTemplate
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {};
		//ResponseEntity：封装了返回信息
		ResponseEntity<List<User>> response = rt.exchange(sb.toString(), HttpMethod.GET,null,type);
		List<User> list = response.getBody();
		return list;
	}
	
}
