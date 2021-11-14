package module_4.case_study.controller;

import module_4.case_study.model.*;
import module_4.case_study.service.*;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IUserService iUserService;
    @Autowired
    IDivisionService iDivisionService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationService iEducationService;

    @ModelAttribute("divisionList")
    public Iterable<Division> getDivision() {
        return iDivisionService.findAll();
    }

    @ModelAttribute("positionList")
    public Iterable<Position> getPosition() {
        return iPositionService.findAll();
    }

    @ModelAttribute("educationList")
    public Iterable<EducationDegree> getEducation() {
        return iEducationService.findAll();
    }

    @GetMapping("")
    public String showIndex(@PageableDefault(value = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Employee> employeeList = iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
//        model.addAttribute("user",new User());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String saveEmployee(@PageableDefault(value = 5) Pageable pageable
//                               ,@ModelAttribute("user") User user
            , @ModelAttribute("employee") Employee employee, Model model) {
        User user = new User(employee.getUser().getUserName(),employee.getUser().getPassword());
        iUserService.save(user);
        User newUser = iUserService.findByUserName(user.getUserName());
        employee.setUser(newUser);
        iEmployeeService.save(employee);
        model.addAttribute("success", "Create customer successfully !");
        Page<Employee> employeeList = iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employeeEdit =iEmployeeService.findById(id);
        User user = iUserService.findById(employeeEdit.getUser().getId());
        model.addAttribute("employeeEdit",employeeEdit );
        model.addAttribute("user",user);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("employeeEdit") Employee employee, Model model) {
        User user = iUserService.findById(employee.getUser().getId());
        user.setUserName(employee.getUser().getUserName());
        user.setUserName(employee.getUser().getPassword());
        iUserService.update(user);
        User newUser = iUserService.findById(user.getId());
        employee.setUser(newUser);
        iEmployeeService.update(employee);
        model.addAttribute("success", "Update customer successfully !");
        return "/employee/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idEmployee") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iEmployeeService.delete(id);
        model.addAttribute("success", "Delete employee successfully !");
        Page<Employee> employeeList = iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@RequestParam("allIdEmployee") String allIdEmployee, Model model, @PageableDefault(value = 5) Pageable pageable) {
        iEmployeeService.deleteAllId(allIdEmployee);
        model.addAttribute("success", "Delete employee successfully !");
        Page<Employee> employeeList = iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "code", defaultValue = "", required = false) String code,
                         @RequestParam(value = "name", defaultValue = "", required = false) String name,
                         @RequestParam(value = "birthDay", defaultValue = "", required = false) String birthDay,
                         @RequestParam(value = "idCard", defaultValue = "", required = false) String idCard,
                         @RequestParam(value = "salary", defaultValue = "", required = false) String salary,
                         @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
                         @RequestParam(value = "email", defaultValue = "", required = false) String email,
                         @RequestParam(value = "address", defaultValue = "", required = false) String address,
                         @RequestParam(value = "position", defaultValue = "", required = false) String position,
                         @RequestParam(value = "educationDegree", defaultValue = "", required = false) String educationDegree,
                         @RequestParam(value = "division", defaultValue = "", required = false) String division,
                         @RequestParam(value = "usename", defaultValue = "", required = false) String usename,
                         Model model,@PageableDefault(value = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable
    ) {

        Page<Employee> employeeList = iEmployeeService.searchAll(pageable,code,name,birthDay,idCard,salary,phone,email,address,position,educationDegree,division,usename);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("code",code);
        model.addAttribute("name",name);
        model.addAttribute("birthDay",birthDay);
        model.addAttribute("idCard",idCard);
        model.addAttribute("salary",salary);
        model.addAttribute("phone",phone);
        model.addAttribute("email",email);
        model.addAttribute("address",address);
        model.addAttribute("position",position);
        model.addAttribute("educationDegree",educationDegree);
        model.addAttribute("division",division);
        model.addAttribute("usename",usename);
        return "/employee/list";
    }


}
