package module_4.case_study.service.impl;

import module_4.case_study.dto.CustomerDetail;
import module_4.case_study.repository.ICustomerRepository;
import module_4.case_study.service.ICustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailServiceImpl implements ICustomerDetailService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerDetail> getDetailCustomer(Long idCustomer) {
        return iCustomerRepository.getDetailCustomer(idCustomer);
    }
}
