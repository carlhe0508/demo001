package com.example.demo.job;

import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class CreateUserCronJob {
    @Resource
    private UserService userService;

    @Scheduled(cron = "0/5 * 5 * * *")
    public void scheduled() {
        SysUser sysUser = new SysUser("CARL" + String.valueOf(UUID.randomUUID()), "767791569@qq.com", "1234", new Date());
        userService.addUser(sysUser);
        log.info("create a new user. username:" + sysUser.getName());
    }

//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//        log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
//    }

}
