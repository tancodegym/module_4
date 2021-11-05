package case_study_module4.controller;

import case_study_module4.model.Customer;
import case_study_module4.model.CustomerType;
import case_study_module4.service.ICustomerService;
import case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customertypies")
    public Iterable<CustomerType> categories() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping("")
    public String showIndex(@PageableDefault(value = 10)Pageable pageable, Model model)
    {
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList",customerList);
       return "/customer/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }
    @PostMapping("/create")
    public String saveCustomer(@PageableDefault(value =10)Pageable pageable,@ModelAttribute("customer") Customer customer,Model model){
        model.addAttribute("success","Create customer successfully !");
        iCustomerService.save(customer);

        return "/customer/create";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id")Long id, Model model){
        model.addAttribute("customerEdit",iCustomerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("customerEdit") Customer customer, Model model){
        iCustomerService.update(customer);
        model.addAttribute("success","Update customer successfully !");
        return "/customer/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("idCustomer")Long id, Model model,@PageableDefault(value = 10)Pageable pageable){
        iCustomerService.delete(id);
        model.addAttribute("success","Delete customer successfully !");
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList",customerList);
        return "/customer/list";
    }
}
