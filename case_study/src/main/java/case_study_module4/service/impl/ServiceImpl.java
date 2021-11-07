package case_study_module4.service.impl;

import case_study_module4.repository.IServiceRepository;
import case_study_module4.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceImpl implements IService {
    @Autowired
    IServiceRepository iServiceRepository;

    @Override
    public Iterable<case_study_module4.model.Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Page<case_study_module4.model.Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public case_study_module4.model.Service findById(Long id) {
        return iServiceRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public void save(case_study_module4.model.Service service) {
        service.setCode(getServiceCode());
        iServiceRepository.save(service);
    }

    @Override
    public void update(case_study_module4.model.Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void deleteAllId(String allIdService) {
        List<Long> idList = getListId(allIdService);
        for(Long id: idList){
            iServiceRepository.deleteById(id);
        }
    }
    private List<Long> getListId(String listId){
        List<Long> idList = new ArrayList<>();
        String[] arrayId = listId.split(",");
        for (String string : arrayId) {
            if(string.equals("")){
                continue;
            }
            idList.add(Long.valueOf(string));
        }
        return idList;
    }





    private String getServiceCode() {
        String code = "DV-";
        List<Integer> codeList = new ArrayList<>();
        List<case_study_module4.model.Service> serviceList = iServiceRepository.findAll();
        for (case_study_module4.model.Service service : serviceList) {
            String[] arrayCode = service.getCode().split("-");
            codeList.add(Integer.parseInt(arrayCode[1]));
        }
        Collections.sort(codeList);
        int index = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (i == codeList.size()-1) {
                index = codeList.size();
                break;
            }
            if (codeList.get(i + 1) - codeList.get(i) >= 2) {
                index = i + 1;
                break;
            }
        }
        if (index > 998) {
            return code += (index + 1);
        }
        if (index > 98) {
            return code += "0" + (index + 1);
        }
        if (index > 8) {
            return code += "00" + (index + 1);
        }
        if (index > 0) {
            return code += "000" + (index + 1);
        }
        return code;
    }
}
