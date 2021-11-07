package case_study_module4.repository;

import case_study_module4.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository  extends JpaRepository<Division,Long> {
}
