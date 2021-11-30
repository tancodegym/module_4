package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.model.Pig;
import com.example.demo.service.ICountryService;
import com.example.demo.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pig")
public class PigController {

    @Autowired
    ICountryService iCountryService;
    @ModelAttribute("countryList")
    public List<Country> getListCountry(){
        return iCountryService.findAll();
    }
    @Autowired
    IPigService iPigService;
    @GetMapping(value={"","/search"})
    public String showList(Pageable pageable,
                              @RequestParam(value="status",defaultValue = "",required = false) String status,
                              @RequestParam(value="pigCode",defaultValue = "",required = false) String pigCode,
                              @RequestParam(value="country",defaultValue = "",required = false) String country,
                           Model model){
        model.addAttribute("pigList",iPigService.search(pageable, status, pigCode, country));
        model.addAttribute("status",status);
        model.addAttribute("pigCode",pigCode);
        model.addAttribute("country",country);
        return "/list";


    }



}
