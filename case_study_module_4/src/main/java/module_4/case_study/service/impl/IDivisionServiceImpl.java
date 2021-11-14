package module_4.case_study.service.impl;

import module_4.case_study.model.Division;
import module_4.case_study.repository.IDivisionRepository;
import module_4.case_study.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDivisionServiceImpl  implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
