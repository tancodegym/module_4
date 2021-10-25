package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConvertController {
    @RequestMapping("/convert")
    public String showList(HttpServletRequest request, Model model) {
        double usd= Double.parseDouble(request.getParameter("usd"));
        double vnd = usd*23000;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
