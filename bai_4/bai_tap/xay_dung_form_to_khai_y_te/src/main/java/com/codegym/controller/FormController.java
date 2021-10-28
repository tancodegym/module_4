package com.codegym.controller;

import com.codegym.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping("/form")
    public String showForm(){
        System.out.println(123);
        return "form";
    }
    @GetMapping("/info")
    public String showForm1(){
        return "save";
    }
}
