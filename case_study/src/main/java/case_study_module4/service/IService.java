package case_study_module4.service;

import case_study_module4.model.Service;
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
