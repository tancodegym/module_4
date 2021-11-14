package module_4.case_study.repository;

import module_4.case_study.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
}
