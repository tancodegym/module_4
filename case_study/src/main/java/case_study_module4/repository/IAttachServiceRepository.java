package case_study_module4.repository;

import case_study_module4.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository  extends JpaRepository<AttachService,Long> {
}
