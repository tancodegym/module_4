package module_4.case_study.service;

import module_4.case_study.model.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
