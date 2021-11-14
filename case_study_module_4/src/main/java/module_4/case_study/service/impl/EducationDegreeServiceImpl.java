package module_4.case_study.service.impl;

import module_4.case_study.model.EducationDegree;
import module_4.case_study.repository.IEducationDegreeRepository;
import module_4.case_study.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl  implements IEducationService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
