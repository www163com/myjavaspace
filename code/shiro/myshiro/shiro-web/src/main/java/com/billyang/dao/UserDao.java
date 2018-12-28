package com.billyang.dao;

import com.billyang.vo.User;

import java.util.List;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.dao
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 9:50
 */
public interface UserDao {
    User getUserByUserName(String userNamme);

    List<String> queryRolesByUserName(String userName);
}
