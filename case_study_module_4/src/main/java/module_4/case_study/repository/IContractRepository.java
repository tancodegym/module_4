package module_4.case_study.repository;

import module_4.case_study.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository  extends JpaRepository<Contract,Long> {
}
