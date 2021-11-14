package module_4.case_study.service.impl;

import module_4.case_study.dto.CustomerInUsing;
import module_4.case_study.repository.ICustomerRepository;
import module_4.case_study.service.ICustomerInUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInUsingServiceImpl implements ICustomerInUsingService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerInUsing> getList(int page,int size) {
        List<CustomerInUsing> customerInUsingPage= iCustomerRepository.getList(page,size);
        System.out.println(customerInUsingPage.toString());
        return customerInUsingPage;
    }
}
