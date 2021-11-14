package module_4.case_study.repository;

import module_4.case_study.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Long> {
}
