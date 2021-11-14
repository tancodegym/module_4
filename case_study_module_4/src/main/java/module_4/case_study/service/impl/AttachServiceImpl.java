package module_4.case_study.service.impl;

import module_4.case_study.model.AttachService;
import module_4.case_study.repository.IAttachServiceRepository;
import module_4.case_study.service.IAttachService;
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
