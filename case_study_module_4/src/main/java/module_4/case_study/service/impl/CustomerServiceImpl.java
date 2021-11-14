package module_4.case_study.service.impl;

import module_4.case_study.model.Customer;
import module_4.case_study.repository.ICustomerRepository;
import module_4.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customer.setCode(getCustomerCode());
        iCustomerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteAllId(String allIdCustomer) {
        List<Long> idList = getListId(allIdCustomer);
        for(Long id: idList){
            iCustomerRepository.deleteById(id);
        }
    }

    @Override
    public Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender, String idCard, String email, String phone, String address, String typeCustomer) {
//        return null;
        return iCustomerRepository.searchAll(pageable,"%"+code+"%","%"+name+"%","%"+birthDay+"%","%"+gender+"%","%"+idCard+"%","%"+email+"%","%"+phone+"%","%"+address+"%","%"+typeCustomer+"%");
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





    private String getCustomerCode() {
        String code = "KH-";
        List<Integer> codeList = new ArrayList<>();
        List<Customer> customerList = iCustomerRepository.findAll();
        for (Customer customer : customerList) {
            String[] arrayCode = customer.getCode().split("-");
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
