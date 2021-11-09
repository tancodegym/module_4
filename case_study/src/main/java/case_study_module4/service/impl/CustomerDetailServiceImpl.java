package case_study_module4.service.impl;

import case_study_module4.dto.CustomerDetail;
import case_study_module4.repository.ICustomerRepository;
import case_study_module4.service.ICustomerDetailService;
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
