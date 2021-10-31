package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, Model model) {
        iBlogService.save(blog);
        model.addAttribute("messageCreate", "Create New Blog Successfully !");
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/index";
    }

    @GetMapping("")
    public String showIndex(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/update";

    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, Model model) {
        iBlogService.update(blog);
        model.addAttribute("success", "Update Blog Successfully !");
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id,Model model) {
        iBlogService.remove(id);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("success", "Delete Blog Successfully !");
        return "/blog/index";
    }
    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id,Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/view";
    }


}
