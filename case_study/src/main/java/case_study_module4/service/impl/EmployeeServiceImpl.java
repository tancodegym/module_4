package case_study_module4.service.impl;

import case_study_module4.model.Customer;
import case_study_module4.model.Employee;
import case_study_module4.repository.IEmployeeRepository;
import case_study_module4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepository.delete(findById(id));
    }

    @Override
    public void save(Employee employee) {
        employee.setCode(getEmployeeCode());
        iEmployeeRepository.save(employee);
    }



    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteAllId(String allIdEmployee) {
        List<Long> idList = getListId(allIdEmployee);
        for (Long id : idList) {
            iEmployeeRepository.deleteById(id);
        }
    }

    @Override
    public Page<Employee> searchAll(Pageable pageable, String code, String name, String birthDay, String idCard, String salary, String phone, String email, String address, String position, String educationDegree, String division,String username) {
        Page<Employee> employees= iEmployeeRepository.searchAll(pageable,"%"+code+"%","%"+name+"%","%"+birthDay+"%","%"+idCard+"%","%"+salary+"%","%"+phone+"%","%"+email+"%","%"+address+"%","%"+position+"%","%"+educationDegree+"%","%"+division+"%","%"+username+"%");
        return employees;
    }
    private List<Long> getListId(String listId) {
        List<Long> idList = new ArrayList<>();
        String[] arrayId = listId.split(",");
        for (String string : arrayId) {
            if (string.equals("")) {
                continue;
            }
            idList.add(Long.valueOf(string));
        }
        return idList;
    }


    private String getEmployeeCode() {
        String code = "NV-";
        List<Integer> codeList = new ArrayList<>();
        List<Employee> employeeList = iEmployeeRepository.findAll();
        for (Employee employee : employeeList) {
            String[] arrayCode = employee.getCode().split("-");
            codeList.add(Integer.parseInt(arrayCode[1]));
        }
        Collections.sort(codeList);
        int index = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (i == codeList.size() - 1) {
                index = codeList.size();
                break;
            }
            if (codeList.get(i + 1) - codeList.get(i) >= 2) {
                index = i + 1;
                break;
            }
        }
        if (index > 998) {
            return code += (index + 1);
        }
        if (index > 98) {
            return code += "0" + (index + 1);
        }
        if (index > 8) {
            return code += "00" + (index + 1);
        }
        if (index > 0) {
            return code += "000" + (index + 1);
        }
        return code;
    }
}
