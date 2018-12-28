package com.billyang.dao.impl;

import com.billyang.dao.UserDao;
import com.billyang.vo.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.dao.impl
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 9:51
 */
@Component
public class UserDaoImpl implements UserDao{
    @Resource
    private JdbcTemplate jdbcTemplate;
    public User getUserByUserName(String userNamme) {
        String sql = "select username,password from users where username=?";
        List<User> list = jdbcTemplate.query(sql, new String[]{userNamme}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    public List<String> queryRolesByUserName(String userName) {
        String sql = "select role_name from user_roles where username=?";
        List<String> list = jdbcTemplate.query(sql, new String[]{userName}, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("role_name");
            }
        });

        return list;
    }
}
