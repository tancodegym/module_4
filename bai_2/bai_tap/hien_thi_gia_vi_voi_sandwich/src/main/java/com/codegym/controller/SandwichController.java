package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @RequestMapping("/sandwich")
    public String save(@RequestParam(value = "condiment",defaultValue = "No condiment") String[] condiment
            , Model model) {
//        System.out.println(Arrays.toString(condiment));
        model.addAttribute("condiment", condiment);
        return "result";

    }
}
