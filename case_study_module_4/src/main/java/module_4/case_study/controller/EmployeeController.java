package module_4.case_study.controller;

import module_4.case_study.dto.EmployeeDTO;
import module_4.case_study.model.*;
import module_4.case_study.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public String showIndex(@PageableDefault(value = 3, sort = "code", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Employee> employeeList = iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String saveEmployee(@ModelAttribute @Validated EmployeeDTO employeeDTO,
                               BindingResult bindingResult, Model model) {
        List<Employee> employeeList = iEmployeeService.findAll();
        employeeDTO.setEmployeeList(employeeList);
        List<User> userList = iUserService.findAll();
        employeeDTO.setUserList(userList);
        new EmployeeDTO().validate(employeeDTO,bindingResult);

        if(!bindingResult.hasFieldErrors()){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            User user = new User(employeeDTO.getUser().getUserName(), employeeDTO.getUser().getPassword());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            iUserService.save(user);
            User newUser = iUserService.findByUserName(user.getUserName());
            employee.setUser(newUser);
            iEmployeeService.save(employee);
            Long pos = employee.getPosition().getId();
            if((pos !=5) && (pos != 6)){
                iUserService.addUser(newUser.getId(), (long) 4);
            }else{
                iUserService.addAdmin(newUser.getId(),(long) 1,(long) 4);
            }
            model.addAttribute("success", "Create employee successfully !");

        }
        return "/employee/create";

    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employeeEdit = iEmployeeService.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeEdit,employeeDTO);
        User user = iUserService.findById(employeeEdit.getUser().getId());
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("user", user);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    @Transactional
    public String updateEmployee( @Validated  @ModelAttribute EmployeeDTO employeeDTO,
            BindingResult bindingResult, Model model) {
        List<Employee> employeeList = iEmployeeService.findAll();
        employeeDTO.setEmployeeList(employeeList);
        List<User> userList = iUserService.findAll();
        employeeDTO.setUserList(userList);
        new EmployeeDTO().validate(employeeDTO,bindingResult);

        if(!bindingResult.hasFieldErrors()){
            User user = iUserService.findById(employeeDTO.getUser().getId());
            user.setUserName(employeeDTO.getUser().getUserName());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(employeeDTO.getUser().getPassword()));
            iUserService.update(user);

            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            iEmployeeService.update(employee);

            model.addAttribute("success", "Update customer successfully !");
        }


        return "/employee/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idEmployee") Long id, Model model, @PageableDefault(value = 3) Pageable pageable) {
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
                         Model model, @PageableDefault(value = 3, sort = "code", direction = Sort.Direction.ASC) Pageable pageable
    ) {

        Page<Employee> employeeList = iEmployeeService.searchAll(pageable, code, name, birthDay, idCard, salary, phone, email, address, position, educationDegree, division, usename);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("code", code);
        model.addAttribute("name", name);
        model.addAttribute("birthDay", birthDay);
        model.addAttribute("idCard", idCard);
        model.addAttribute("salary", salary);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        model.addAttribute("position", position);
        model.addAttribute("educationDegree", educationDegree);
        model.addAttribute("division", division);
        model.addAttribute("usename", usename);
        return "/employee/list";
    }


}
