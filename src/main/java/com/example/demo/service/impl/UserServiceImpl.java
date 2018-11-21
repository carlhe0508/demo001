package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.SysUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;
    @Resource
    private UserMapper userMapper;

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

    @Override
    public Page<SysUser> getPagedUsers() {
        Sort sort = new Sort(Sort.Direction.DESC, "dob"); //创建时间降序排序
        Pageable pageable = new PageRequest(1, 5, sort);
        Page<SysUser> pageData = userRepository.findAll(pageable);
        return pageData;
    }

    @Override
    public List<User> getAllUser() {
        PageHelper.startPage(2, 5);
        return userMapper.selsctAllUsrs();
    }
}
