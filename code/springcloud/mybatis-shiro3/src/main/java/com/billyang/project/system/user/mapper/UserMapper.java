package com.billyang.project.system.user.mapper;

import java.util.List;

import com.billyang.project.system.user.domain.User;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：UserMapper   
* 类描述：   查询用户信息
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午10:48:30   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午10:48:30   
* 修改备注：   
* @version    
*    
*/
public interface UserMapper
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<User> selectUserList(User user);

}
