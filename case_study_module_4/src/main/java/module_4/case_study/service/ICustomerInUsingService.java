package module_4.case_study.service;

import module_4.case_study.dto.CustomerInUsing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerInUsingService {
    List<CustomerInUsing> getList(int page, int size);

}
