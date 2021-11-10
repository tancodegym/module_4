package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return iCategoryService.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, Model model,@PageableDefault(value = 3) Pageable pageable) {
        blog.setDate(new Date(System.currentTimeMillis()));
        iBlogService.save(blog);
        model.addAttribute("messageCreate", "Create New Blog Successfully !");
        model.addAttribute("blogList", iBlogService.findAll(pageable));
        return "/index";
    }

    @GetMapping("")
    public String showIndex(
            @RequestParam(value="seach",defaultValue = "",required = false) String search,
            @RequestParam(value="idCategory",defaultValue = "",required = false)String idCategory,
            Model model,
            @PageableDefault(value = 3,sort ="date",direction = Sort.Direction.DESC)Pageable pageable) {
//        List<Blog> blogList = iBlogService.findAll(pageable);
        Page<Blog> blogList = iBlogService.findAll(pageable,search,idCategory);
        model.addAttribute("blogList",blogList);
        model.addAttribute("search",search);
        model.addAttribute("idCategory",idCategory);
//        model.addAttribute("categories",ca)
//        model.addAttribute("blogList", iBlogService.fdAll(pageable));
        return "/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(Long.valueOf(id)).get();
        model.addAttribute("blog", blog);
        return "/update";

    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, Model model,@PageableDefault(value = 3) Pageable pageable) {
        iBlogService.update(blog);
        model.addAttribute("success", "Update Blog Successfully !");
        model.addAttribute("blogList", iBlogService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id, Model model) {
        iBlogService.remove((long) id);
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        model.addAttribute("success", "Delete Blog Successfully !");
        return "/index";
    }
    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(Long.valueOf(id)).get();
        model.addAttribute("blog", blog);
        return "/view";
    }


}
