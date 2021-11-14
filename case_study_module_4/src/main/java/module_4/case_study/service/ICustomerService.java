package module_4.case_study.service;

import module_4.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void delete(Long id);
    void save(Customer customer);
    void update(Customer customer);

    void deleteAllId(String allIdCustomer);

    Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender, String idCard, String email, String phone, String address, String typeCustomer);
}
