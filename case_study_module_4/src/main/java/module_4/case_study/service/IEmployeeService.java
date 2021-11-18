package module_4.case_study.service;

import module_4.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
    void delete(Long id);
    void save(Employee employee);
    void update(Employee employee);

    void deleteAllId(String allIdEmployee);

    Page<Employee> searchAll(Pageable pageable, String code, String name, String birthDay, String idCard, String salary, String phone, String email, String address, String position, String educationDegree, String division,String username);

//    Page<Employee> searchAll(Pageable pageable, String code, String name, String birthDay, String gender, String idCard, String email, String phone, String address, String typeCustomer);

}
