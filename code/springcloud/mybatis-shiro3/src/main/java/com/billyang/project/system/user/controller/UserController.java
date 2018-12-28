package com.billyang.project.system.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billyang.framework.web.controller.BaseController;
import com.billyang.framework.web.page.TableDataInfo;
import com.billyang.project.system.user.domain.User;
import com.billyang.project.system.user.service.IUserService;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：UserController   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午10:44:27   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午10:44:27   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UserController extends BaseController{
	private String prefix="system/user";
    @Autowired
    private IUserService userService;

	@GetMapping("/list")
	@ResponseBody
	public TableDataInfo List(User user){
		startPage();
		List<User> list = userService.selectUserList(user);
		System.out.println(list.size());
//		return getDataTable(list);
		return null;
	}
}
