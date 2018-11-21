package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    boolean addUser(SysUser record);

    public SysUser getUserByName(String name);

    Page<SysUser> getPagedUsers();

    List<User> getAllUser();
}
