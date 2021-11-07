package case_study_module4.repository;

import case_study_module4.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository  extends JpaRepository<ContractDetail,Long> {
}
