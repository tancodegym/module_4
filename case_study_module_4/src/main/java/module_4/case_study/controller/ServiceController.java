package module_4.case_study.controller;

import module_4.case_study.dto.CustomerDTO;
import module_4.case_study.dto.ServiceDTO;
import module_4.case_study.model.*;
import module_4.case_study.service.*;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService iService;
    @Autowired
    IServiceType iServiceType;
    @Autowired
    IRentTypeService iRentTypeService;

    @ModelAttribute("rentTypies")
    public Iterable<RentType> getRentTypies() {
        return iRentTypeService.findAll();
    }

    @ModelAttribute("serviceTypies")
    public Iterable<ServiceType> getServiceTypies() {
        return iServiceType.findAll();
    }

    @GetMapping("")
    public String showIndex(@PageableDefault(value = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Service> serviceList = iService.findAll(pageable);
        model.addAttribute("services", serviceList);
        return "/service/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        ServiceDTO serviceDTO = new ServiceDTO();
        model.addAttribute("serviceDTO", serviceDTO);
        return "/service/create";
    }

    @PostMapping("/create")
    public String saveService(@ModelAttribute  @Validated ServiceDTO serviceDTO,BindingResult bindingResult, Model model) {

        new ServiceDTO().validate(serviceDTO,bindingResult);
        if(!bindingResult.hasFieldErrors()){
            Service service= new Service();
            BeanUtils.copyProperties(serviceDTO, service);
            iService.save(service);
            model.addAttribute("success", "Create new service successfully !");
        }
        return "/service/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Service service = iService.findById(id);
        ServiceDTO serviceDTO = new ServiceDTO();
        BeanUtils.copyProperties(service,serviceDTO);
        model.addAttribute("serviceDTO", serviceDTO);
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute @Validated ServiceDTO serviceDTO,BindingResult bindingResult, Model model) {
        new ServiceDTO().validate(serviceDTO,bindingResult);
        if(!bindingResult.hasFieldErrors()){
            Service service= new Service();
            BeanUtils.copyProperties(serviceDTO,service);
            iService.update(service);
            model.addAttribute("success", "Update service successfully !");
        }
        return "/service/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("idService") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iService.delete(id);
        model.addAttribute("success", "Delete service successfully !");
        Page<Service> serviceList = iService.findAll(pageable);
        model.addAttribute("services", serviceList);
        return "/service/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@RequestParam("allIdService") String allIdService, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iService.deleteAllId(allIdService);
        model.addAttribute("success", "Delete service successfully !");
        Page<Service> serviceList = iService.findAll(pageable);
        model.addAttribute("services", serviceList);
        return "/service/list";
    }

}
