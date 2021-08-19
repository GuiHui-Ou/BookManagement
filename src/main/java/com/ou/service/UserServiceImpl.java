package com.ou.service;

import com.ou.dao.UserMapper;
import com.ou.pojo.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Users queryAllUser() {
        return userMapper.queryAllUser();
    }
}
