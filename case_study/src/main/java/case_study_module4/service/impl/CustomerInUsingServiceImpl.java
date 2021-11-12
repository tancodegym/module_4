package case_study_module4.service.impl;

import case_study_module4.dto.CustomerInUsing;
import case_study_module4.repository.ICustomerRepository;
import case_study_module4.service.ICustomerInUsingService;
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
