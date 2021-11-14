package module_4.case_study.service;

import module_4.case_study.model.ContractDetail;
import module_4.case_study.model.Customer;
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
