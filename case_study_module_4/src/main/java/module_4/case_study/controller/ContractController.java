package module_4.case_study.controller;

import module_4.case_study.dto.ContractDTO;
import module_4.case_study.dto.CustomerDTO;
import module_4.case_study.model.*;
import module_4.case_study.service.IContractService;
import module_4.case_study.service.ICustomerService;
import module_4.case_study.service.IEmployeeService;
import module_4.case_study.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IService iService;

    @ModelAttribute("customerList")
    public Iterable<Customer> getCustomerList() {
        return iCustomerService.findAll();
    }

    @ModelAttribute("employeeList")
    public Iterable<Employee> getEmployeeList() {
        return iEmployeeService.findAll();
    }

    @ModelAttribute("serviceList")
    public Iterable<Service> getServiceList() {
        return iService.findAll();
    }


    @GetMapping("")
    public String showIndex(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Contract> contractList = iContractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
//        model.addAttribute("contractCreate", new Contract());
        model.addAttribute("contractDTO", new ContractDTO());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String saveContract(@ModelAttribute @Validated ContractDTO contractDTO, BindingResult bindingResult, Model model) {
        new ContractDTO().validate(contractDTO, bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDTO, contract);
            model.addAttribute("success", "Create new contract successfully !");
            contract.setTotalMoney(contract.getService().getCost());
            iContractService.save(contract);
        }
        return "/contract/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Contract contract = iContractService.findById(id);
        ContractDTO contractDTO = new ContractDTO();
        BeanUtils.copyProperties(contract, contractDTO);
        model.addAttribute("contractDTO", contractDTO);
        return "/contract/edit";
    }

    @PostMapping("/edit")
    public String updateContract(@ModelAttribute @Validated ContractDTO contractDTO, BindingResult bindingResult, Model model) {
        new ContractDTO().validate(contractDTO, bindingResult);
        if ((!bindingResult.hasFieldErrors())) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDTO, contract);
            iContractService.update(contract);
            model.addAttribute("success", "Update contract successfully !");
        }
        return "/contract/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idContract") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iContractService.delete(id);
        model.addAttribute("success", "Delete contract successfully !");
        Page<Contract> contractList = iContractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "/contract/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@RequestParam("allIdContract") String allIdContract, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iContractService.deleteAllId(allIdContract);
        model.addAttribute("success", "Delete contract successfully !");
        Page<Contract> contractList = iContractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "/contract/list";
    }

}
