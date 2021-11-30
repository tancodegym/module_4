package com.example.demo.controller;

import com.example.demo.model.Pig;
import com.example.demo.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PigController {

    @Autowired
    IPigService iPigService;


    public String getList(Model model){
        List<Pig> pigList = iPigService.findAll();
        model.addAttribute("pig",pigList);
        return null;
    }
}
