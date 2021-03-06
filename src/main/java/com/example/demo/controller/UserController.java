package com.example.demo.controller;

import com.example.demo.entity.SysRole;
import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers(Model Model) {

        Page<SysUser> pageInfo = userService.getPagedUsers();
        userService.getAllUser();

        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String initLogin(SysUser sysUser) {
        sysUser.setName("carl" + String.valueOf(UUID.randomUUID()));
        sysUser.setPassword("1234");
        sysUser.setEmail("767791569@qq.com");
        sysUser.setDob(new Date());
        Set<SysRole> roleSet = new HashSet<>();
        SysRole role = new SysRole();
        role.setName("ADMIN");
        roleSet.add(role);
        sysUser.setSRoles(roleSet);
        userService.addUser(sysUser);
        return "page/login";
    }


}
