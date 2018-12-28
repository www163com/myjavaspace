package com.billyang.project.system.user.service;

import java.util.List;

import com.billyang.project.system.user.domain.User;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：IUserService   
* 类描述：   用户业务层
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午10:45:16   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午10:45:16   
* 修改备注：   
* @version    
*    
*/
public interface IUserService {
     /**
     * @param suer
     * @return 用户信息集合信息
     */
    public List<User> selectUserList(User user);
}
