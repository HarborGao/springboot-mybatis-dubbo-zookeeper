package com.harbor.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.harbor.common.domain.User;
import com.harbor.common.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("getContent")
    @ResponseBody
    public String user(@RequestParam String userName, @RequestParam String password){
        User user = userService.findUser(userName);
        if(password.equals(user.getUserPassword())){
            return "1";
        }else{
            return "0";
        }
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(@RequestParam String newName,@RequestParam String newPassword,
                            @RequestParam String repeatPassword){
        if(newPassword.equals(repeatPassword)){
            User user = new User(newName,newPassword);
            userService.addUser(user);
            return "1";
        }else {
            return "0";
        }
    }

    @GetMapping("/login")
    public String getIndex(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/content")
    public String content(){
        return "content";
    }
}