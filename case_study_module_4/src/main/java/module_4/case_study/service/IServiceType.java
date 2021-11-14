package module_4.case_study.service;

import module_4.case_study.model.CustomerType;
import module_4.case_study.model.ServiceType;

import java.util.List;

public interface IServiceType {
    List<ServiceType> findAll();
}
