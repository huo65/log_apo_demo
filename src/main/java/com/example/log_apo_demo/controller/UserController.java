package com.example.log_apo_demo.controller;

import com.example.log_apo_demo.annotation.LogAnnotation;
import com.example.log_apo_demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 1. @ClassName UserController
 * 2. @Description 用户
 * 3. @Author huo
 * 4. @Date 2023/9/21 22:50
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @LogAnnotation("查询用户")
    @GetMapping("/list")
    public List<User> list(){
        return Arrays.asList(
                new User(1,"张三"),
                new User(2,"李四")
        );
    }

    @LogAnnotation("通过id查询用户")
    @GetMapping("/getById/{id}")
    public User getById(@PathVariable("id") Integer id){
    return  new User(id, "五五");
    }
}
