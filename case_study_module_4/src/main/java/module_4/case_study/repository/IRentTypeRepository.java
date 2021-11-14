package module_4.case_study.repository;

import module_4.case_study.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
}
