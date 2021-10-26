package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class CalculatorController {
    @RequestMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @RequestMapping("/calculate")
    public String showResult(@RequestParam("calculate") String[] calculate, Model model, HttpServletRequest request) {
        String calculated = Arrays.toString(calculate);
        String a = request.getParameter("number_a");
        String b= request.getParameter("number_b");
        if(!validateNumber(a)){
            model.addAttribute("result", "Cannot calculate because wrong number format !");
            return "calculator";
        }
        if(!validateNumber(b)){
            model.addAttribute("result", "Cannot calculate because wrong number format !");
            return "calculator";
        }
        double number_a = Double.parseDouble(request.getParameter("number_a"));
        double number_b = Double.parseDouble(request.getParameter("number_b"));
        double result;
        switch (calculated) {
            case "[Addition(+)]":
                result = number_a + number_b;
                model.addAttribute("result", number_a + " " + "+" + " " + number_b + " is: " + result);
                break;
            case "[Subtraction(-)]":
                result = number_a - number_b;
                model.addAttribute("result", number_a + " " + "-" + " " + number_b + " is: " + result);
                break;
            case "[Multiplication(*)]":
                result = number_a * number_b;
                model.addAttribute("result", number_a + " " + "*" + " " + number_b + " is: " + result);
                break;
            case "[Division(/)]":
                result = number_a / number_b;
                model.addAttribute("result", number_a + " " + "/" + " " + number_b + " is: " + result);
                break;
        }
        return "calculator";
    }

    static boolean validateNumber(String number) {
        String NUMBER_REGEX = "(\\d)*";
        if (number.matches(NUMBER_REGEX)) {
            return true;
        } else {
            return false;
        }
    }
}
