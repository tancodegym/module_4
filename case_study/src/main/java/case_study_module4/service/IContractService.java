package case_study_module4.service;

import case_study_module4.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Long id);
    void delete(Long id);
    void save(Contract contract);
    void update(Contract contract);
    void deleteAllId(String allIdContract);
}
