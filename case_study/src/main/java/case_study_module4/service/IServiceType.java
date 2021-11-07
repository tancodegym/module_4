package case_study_module4.service;

import case_study_module4.model.CustomerType;
import case_study_module4.model.ServiceType;

import java.util.List;

public interface IServiceType {
    List<ServiceType> findAll();
}
