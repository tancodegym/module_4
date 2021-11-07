package case_study_module4.service.impl;

import case_study_module4.model.EducationDegree;
import case_study_module4.repository.IEducationDegreeRepository;
import case_study_module4.service.IEducationService;
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
