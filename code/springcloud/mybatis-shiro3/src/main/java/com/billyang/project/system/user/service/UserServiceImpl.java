package com.billyang.project.system.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billyang.project.system.user.domain.User;
import com.billyang.project.system.user.mapper.UserMapper;
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
	@Override
	public List<User> selectUserList(User suer) {
		return userMapper.selectUserList(suer);
	}

}
