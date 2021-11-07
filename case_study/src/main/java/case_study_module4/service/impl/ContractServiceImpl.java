package case_study_module4.service.impl;

import case_study_module4.model.Contract;
import case_study_module4.repository.IContractRepository;
import case_study_module4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Long id) {
        return iContractRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void deleteAllId(String allIdContract) {
        List<Long> idList = getListId(allIdContract);
        for(Long id: idList){
            iContractRepository.deleteById(id);
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
