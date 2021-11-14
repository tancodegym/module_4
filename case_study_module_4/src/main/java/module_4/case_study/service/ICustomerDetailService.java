package module_4.case_study.service;

import module_4.case_study.dto.CustomerDetail;

import java.util.List;

public interface ICustomerDetailService {
    List<CustomerDetail> getDetailCustomer(Long idCustomer);
}
