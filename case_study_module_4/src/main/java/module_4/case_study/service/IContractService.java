package module_4.case_study.service;

import module_4.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Iterable<Contract> findAll();
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Long id);
    void delete(Long id);
    void save(Contract contract);
    void update(Contract contract);
    void deleteAllId(String allIdContract);
}
