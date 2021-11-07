package case_study_module4.controller;

import case_study_module4.model.*;
import case_study_module4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("serviceCreate", new Service());
        return "/service/create";
    }

    @PostMapping("/create")
    public String saveService(@PageableDefault(value = 5) Pageable pageable, @ModelAttribute("service") Service service, Model model) {
        model.addAttribute("success", "Create new service successfully !");
        iService.save(service);
        model.addAttribute("serviceCreate", new Service());
        return "/service/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("serviceEdit", iService.findById(id));
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("serviceEdit") Service service, Model model) {
        iService.update(service);
        model.addAttribute("success", "Update service successfully !");
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
