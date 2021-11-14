package module_4.case_study.service.impl;

import module_4.case_study.model.ContractDetail;
import module_4.case_study.repository.IContractDetailRepository;
import module_4.case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractDetailServiceImpl  implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(Long id) {
        return iContractDetailRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iContractDetailRepository.deleteById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void update(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteAllId(String allIdContractDetail) {
        List<Long> idList = getListId(allIdContractDetail);
        for(Long id: idList){
            iContractDetailRepository.deleteById(id);
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

}
