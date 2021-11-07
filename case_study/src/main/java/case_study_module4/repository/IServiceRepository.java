package case_study_module4.repository;

import case_study_module4.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Long> {
}
