package case_study_module4.service.impl;

import case_study_module4.model.AttachService;
import case_study_module4.repository.IAttachServiceRepository;
import case_study_module4.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl  implements  IAttachService{
    @Autowired
    IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
