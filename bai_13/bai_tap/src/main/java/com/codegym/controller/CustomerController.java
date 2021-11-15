package com.codegym.controller;

import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("customerList",iCustomerService.findAll());
        return "/list";
    }
}
