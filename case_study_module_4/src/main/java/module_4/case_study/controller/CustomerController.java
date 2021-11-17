package module_4.case_study.controller;

import module_4.case_study.dto.CustomerDTO;
import module_4.case_study.dto.CustomerDetail;
import module_4.case_study.dto.CustomerInUsing;
import module_4.case_study.model.Customer;
import module_4.case_study.model.CustomerType;
import module_4.case_study.service.ICustomerDetailService;
import module_4.case_study.service.ICustomerInUsingService;
import module_4.case_study.service.ICustomerService;
import module_4.case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("customerDTO", customerDTO);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute @Validated CustomerDTO customerDTO,
                               BindingResult bindingResult,
                               Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        customerDTO.setCustomers(customerList);
        new CustomerDTO().validate(customerDTO,bindingResult);

        if (!bindingResult.hasFieldErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            iCustomerService.save(customer);
            model.addAttribute("success", "Create customer successfully !");
        }
        return "/customer/create";

    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        model.addAttribute("customerDTO", customerDTO);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String updateCustomer( @Validated  @ModelAttribute CustomerDTO customerDTO,
                               BindingResult bindingResult, Model model) {
        new CustomerDTO().validate(customerDTO,bindingResult);
        if(bindingResult.hasFieldErrors()){
//            model.addAttribute("customerDTOEdit",customerDTOEdit);
            return "/customer/edit";

        }
        else{
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO,customer);
            iCustomerService.update(customer);
            model.addAttribute("success", "Update customer successfully !");
            return "redirect:/customer/";
        }

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
    public String getCustomerInUsing(@RequestParam(value = "page",defaultValue = "0") int page, Model model) {
        List<CustomerInUsing> totalpage = iCustomerInUsingService.getList(0,9999); //viet method #
        int size =2;
        int total= (totalpage.size()+1)/size;
        int page1= page*size;

        List<CustomerInUsing> usingList = iCustomerInUsingService.getList(page1,size);

        model.addAttribute("usingList", usingList);
        model.addAttribute("page",page);
        model.addAttribute("total",total);
        return "/customer/using";
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetailCustomer(@PathVariable("id") Long id) {
        List<CustomerDetail> customerDetailList = iCustomerDetailService.getDetailCustomer(id);
//        model.addAttribute("customerDetailList", customerDetailList);

        return  new ResponseEntity<>(customerDetailList, HttpStatus.OK);
    }
}
