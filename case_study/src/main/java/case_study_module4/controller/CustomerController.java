package case_study_module4.controller;

import case_study_module4.dto.CustomerDetail;
import case_study_module4.dto.CustomerInUsing;
import case_study_module4.model.Customer;
import case_study_module4.model.CustomerType;
import case_study_module4.service.ICustomerDetailService;
import case_study_module4.service.ICustomerInUsingService;
import case_study_module4.service.ICustomerService;
import case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @Autowired
    ICustomerInUsingService iCustomerInUsingService;
    @Autowired
    ICustomerDetailService iCustomerDetailService;

    @ModelAttribute("customertypies")
    public Iterable<CustomerType> getType() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping("")
    public String showIndex(@PageableDefault(value = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList", customerList);

        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@PageableDefault(value = 5) Pageable pageable, @ModelAttribute("customer") Customer customer, Model model) {
        model.addAttribute("success", "Create customer successfully !");
        iCustomerService.save(customer);
        return "/customer/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customerEdit", iCustomerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("customerEdit") Customer customer, Model model) {
        iCustomerService.update(customer);
        model.addAttribute("success", "Update customer successfully !");
        return "/customer/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idCustomer") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iCustomerService.delete(id);
        model.addAttribute("success", "Delete customer successfully !");
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@RequestParam("allIdCustomer") String allIdCustomer, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iCustomerService.deleteAllId(allIdCustomer);
        model.addAttribute("success", "Delete customer successfully !");
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "code", defaultValue = "", required = false) String code,
                         @RequestParam(value = "name", defaultValue = "", required = false) String name,
                         @RequestParam(value = "birthDay", defaultValue = "", required = false) String birthDay,
                         @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
                         @RequestParam(value = "idCard", defaultValue = "", required = false) String idCard,
                         @RequestParam(value = "email", defaultValue = "", required = false) String email,
                         @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
                         @RequestParam(value = "address", defaultValue = "", required = false) String address,
                         @RequestParam(value = "typeCustomer", defaultValue = "", required = false) String typeCustomer,
                         Model model, @PageableDefault(value = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Customer> customerList = iCustomerService.searchAll(pageable, code, name, birthDay, gender, idCard, email, phone, address, typeCustomer);
        model.addAttribute("customerList", customerList);
        model.addAttribute("code", code);
        model.addAttribute("name", name);
        model.addAttribute("birthDay", birthDay);
        model.addAttribute("gender", gender);
        model.addAttribute("idCard", idCard);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("address", address);
        model.addAttribute("typeCustomer", typeCustomer);
        return "/customer/list";
    }

    @GetMapping("/customer_using")
    public String getCustomerInUsing(@PageableDefault(value=5,sort = "contract",direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<CustomerInUsing> usingList = iCustomerInUsingService.getList(pageable);
        model.addAttribute("usingList", usingList);
        return "/customer/using";
    }

    @GetMapping("/detail/{id}")
    public String getDetailCustomer(@PathVariable("id") Long id, Model model) {
        List<CustomerDetail> customerDetailList = iCustomerDetailService.getDetailCustomer(id);
        model.addAttribute("customerDetailList", customerDetailList);
        return "/customer/detail";
    }
}
