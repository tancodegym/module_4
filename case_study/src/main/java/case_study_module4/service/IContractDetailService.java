package case_study_module4.service;

import case_study_module4.model.ContractDetail;
import case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
    ContractDetail findById(Long id);
    void delete(Long id);
    void save(ContractDetail contractDetail);
    void update(ContractDetail contractDetail);

    void deleteAllId(String allIdContractDetail);

//    Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender, String idCard, String email, String phone, String address, String typeCustomer);
}
