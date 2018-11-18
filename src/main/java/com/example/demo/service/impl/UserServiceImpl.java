package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public boolean addUser(SysUser record) {
        boolean result = false;
        try {
            encryptPassword(record);
            userRepository.save(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public SysUser getUserByName(String name) {
        return userRepository.findSysUserByName(name);
    }

    private void encryptPassword(SysUser userInfo) {
        String password = userInfo.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userInfo.setPassword(password);
    }


}
