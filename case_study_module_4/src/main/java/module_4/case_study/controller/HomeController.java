package module_4.case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHomePage(){
        return "home";
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
