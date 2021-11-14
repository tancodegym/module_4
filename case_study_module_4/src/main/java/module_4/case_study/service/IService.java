package module_4.case_study.service;

import module_4.case_study.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {
    Iterable<Service> findAll();
    Page<Service> findAll(Pageable pageable);
    Service findById(Long id);
    void delete(Long id);
    void save(Service service);
    void update(Service service);

    void deleteAllId(String allIdService);
}
