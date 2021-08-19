package com.ou.controller;

import com.ou.pojo.Users;
import com.ou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String pwd) {
        Users userName = userService.queryAllUser();
        if (username.equals(userName.getUserName()) && pwd.equals(userName.getUserPassword())) {
            return "redirect:/book/allBook";
        }else
        {
            return "loginfail";
        }
    }
}
