package com.codegym.service;

import com.codegym.model.Address;
import com.codegym.model.EndDate;
import com.codegym.model.Person;
import com.codegym.model.StartDate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImplement implements IPersonService{
    static Person person;
    static {
        StartDate startDate = new StartDate(3,3,2021);
        EndDate endDate = new EndDate(3,3,2021);
        List<String> countryList = new ArrayList<>();
        countryList.add("Hồ Chí Minh");
        countryList.add("Đà Nẵng");
        countryList.add("Hà Nội");
        countryList.add("Hải Phòng");
        List<String> dictrictList = new ArrayList<>();
        dictrictList.add("Quận 1");
        dictrictList.add("Quận 2");
        dictrictList.add("Quận 3");
        dictrictList.add("Quận 4");
        dictrictList.add("Quận 5");
        List<String> wardList = new ArrayList<>();
        wardList.add("Phường 1");
        wardList.add("Phường 2");
        wardList.add("Phường 3");
        wardList.add("Phường 4");
        wardList.add("Phường 5");
        Address address = new Address(countryList,dictrictList,wardList,"117 Đường ABC");
        boolean[] symptom = {true,false,true,false,true,false,true,false};
        boolean[] history = {true,false};
        person=new Person("Nguyễn Văn A",1995,0,"Việt Nam",
                "201605626",1,"VN123","A1",startDate,endDate,"Hồ Chí Minh",
                address,"0947829245","tan@gmail.com", symptom,history);
    }

    @Override
    public void save(Person person1) {
        person= person1;

    }

    @Override
    public Person getInfo() {
        return person;
    }
}
