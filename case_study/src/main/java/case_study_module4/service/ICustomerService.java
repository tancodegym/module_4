package case_study_module4.service;

import case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void delete(Long id);
    void save(Customer customer);
    void update(Customer customer);

    void deleteAllId(String allIdCustomer);

    Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender, String idCard, String email, String phone, String address, String typeCustomer);
}
