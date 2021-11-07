package case_study_module4.service.impl;

import case_study_module4.model.ServiceType;
import case_study_module4.repository.ICustomerTypeRepository;
import case_study_module4.repository.IServiceTypeRepository;
import case_study_module4.service.IServiceType;
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
