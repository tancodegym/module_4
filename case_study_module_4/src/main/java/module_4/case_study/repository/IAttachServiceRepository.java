package module_4.case_study.repository;

import module_4.case_study.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository  extends JpaRepository<AttachService,Long> {
}
