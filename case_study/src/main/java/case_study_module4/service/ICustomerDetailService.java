package case_study_module4.service;

import case_study_module4.dto.CustomerDetail;

import java.util.List;

public interface ICustomerDetailService {
    List<CustomerDetail> getDetailCustomer(Long idCustomer);
}
