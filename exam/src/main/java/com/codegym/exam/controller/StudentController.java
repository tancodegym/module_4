package com.codegym.exam.controller;

import com.codegym.exam.model.ClassName;
import com.codegym.exam.service.IClassNameService;
import com.codegym.exam.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClassNameService iClassNameService;
    @ModelAttribute("/classNameList")
    public List<ClassName> getClassList(){
        return iClassNameService.getList();
    }


    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("studentList",iStudentService.getList());
        return "/student/list";

    }

}
