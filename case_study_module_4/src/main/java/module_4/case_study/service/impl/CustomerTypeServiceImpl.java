package module_4.case_study.service.impl;

import module_4.case_study.model.CustomerType;
import module_4.case_study.repository.ICustomerTypeRepository;
import module_4.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
