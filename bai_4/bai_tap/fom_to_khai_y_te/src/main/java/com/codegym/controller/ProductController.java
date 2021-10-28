package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private  IProductService iProductService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping(value = "/save",produces ="application/x-www-form-urlencoded;charset=UTF-8")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        redirect.addFlashAttribute("success", "Create "+product.getName()+" success !");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirect) {
        iProductService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Edit "+product.getName()+" success !");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed "+product.getName()+" successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("product", new Product());
        return "/search";
    }
    @PostMapping("/find")
    public String find(Product product ,Model model) {
        String name = product.getName();
        List<Product> productList = iProductService.findByName(name);
        model.addAttribute("products", productList);
        return "result";
    }
}
