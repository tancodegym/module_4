package com.codegym.controller;

import com.codegym.model.Person;
import com.codegym.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping("/form")
    public String showForm(Model model){
        List<String> countryList = new ArrayList<>();
        countryList.add("Hồ Chí Minh");
        countryList.add("Đà Nẵng");
        countryList.add("Hà Nội");
        countryList.add("Hải Phòng");
        List<String> dictrictList = new ArrayList<>();
        dictrictList.add("Quận 1");
        dictrictList.add("Quận 2");
        dictrictList.add("Quận 3");
        dictrictList.add("Quận 4");
        dictrictList.add("Quận 5");
        List<String> wardList = new ArrayList<>();
        wardList.add("Phường 1");
        wardList.add("Phường 2");
        wardList.add("Phường 3");
        wardList.add("Phường 4");
        wardList.add("Phường 5");
        model.addAttribute("person",new Person());
        model.addAttribute("countryList",countryList);
        model.addAttribute("wardList",wardList);
        model.addAttribute("dictrictList",dictrictList);

        return "form/form";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Person person, Model model){
        iPersonService.save(person);
        model.addAttribute("khaibao",
                "Khai báo y tế thành công");
        return "form/result";
    }
    @GetMapping("/edit")
    public String editForm(@ModelAttribute Person person, Model model){
        model.addAttribute("person",iPersonService.getInfo());
        return "form/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Person person, Model model){
        iPersonService.save(person);
        model.addAttribute("chinhsua",
                "Chỉnh sửa thành công");
        return "form/result";
    }

}
