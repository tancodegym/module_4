package module_4.case_study.service.impl;

import module_4.case_study.model.ServiceType;
import module_4.case_study.repository.ICustomerTypeRepository;
import module_4.case_study.repository.IServiceTypeRepository;
import module_4.case_study.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    IServiceTypeRepository iServiceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
