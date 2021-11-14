package module_4.case_study.repository;

import module_4.case_study.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository  extends JpaRepository<ContractDetail,Long> {
}
