package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/login")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String initLogin(final Model model) {
        User user = new User();
        user.setUsernmae("wangwu");
        userService.addUser(user);
        return "hello";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserById(final Model model) {
        model.addAttribute("user", userService.getUserById("1"));
        PageHelper.startPage(1,5);
        List<User> userList=userService.findAll();





        PageInfo pageInfo=new PageInfo(userList);
        model.addAttribute("allUser",pageInfo);
        return userList;
    }
}
