package module_4.case_study.repository;

import module_4.case_study.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Long> {
}
