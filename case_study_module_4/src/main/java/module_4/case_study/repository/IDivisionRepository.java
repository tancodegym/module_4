package module_4.case_study.repository;

import module_4.case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository  extends JpaRepository<Division,Long> {
}
