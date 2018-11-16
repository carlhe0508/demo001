package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record) {
        boolean result = false;
        try {
            userMapper.insert(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<User> findAll() {
        PageHelper.startPage(1,5);
        return userMapper.findAll();
    }
}
