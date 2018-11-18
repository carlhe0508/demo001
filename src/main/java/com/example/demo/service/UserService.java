package com.example.demo.service;

import com.example.demo.entity.SysUser;

public interface UserService {

    boolean addUser(SysUser record);


    public SysUser getUserByName(String name);
}
