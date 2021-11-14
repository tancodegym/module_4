package module_4.case_study.service.impl;

import module_4.case_study.model.RentType;
import module_4.case_study.repository.IRentTypeRepository;
import module_4.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
