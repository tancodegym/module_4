package case_study_module4.repository;

import case_study_module4.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository  extends JpaRepository<Contract,Long> {
}
