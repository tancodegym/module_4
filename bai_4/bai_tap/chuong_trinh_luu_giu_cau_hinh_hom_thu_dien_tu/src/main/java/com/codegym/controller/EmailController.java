package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IEmailService iEmailService;


    @GetMapping(value = "")
    public ModelAndView showEmail(ModelMap model) {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Chinese");
        languageList.add("Japanese");
        List<Integer> sizeList = new ArrayList<>();
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);
        model.addAttribute("languageList",languageList);
        model.addAttribute("sizeList",sizeList);
        return new ModelAndView("info","email",iEmailService.getEmail());
    }
    @PostMapping("update")
    public String updateEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        iEmailService.updateEmail(email);
        redirectAttributes.addFlashAttribute("success","Update Email Success !");
        return "redirect:/email/success";

    }
    @GetMapping("success")
    public String showSuccess(){
        return "success";
    }

}
