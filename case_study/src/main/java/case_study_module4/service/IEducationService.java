package case_study_module4.service;

import case_study_module4.model.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
