package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }
    @GetMapping("/member")
    public String getMemberPage(){
        return "member";
    }
    @GetMapping("/404")
    public String get404Page(){
        return "404";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
