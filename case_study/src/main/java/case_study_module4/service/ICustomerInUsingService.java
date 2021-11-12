package case_study_module4.service;

import case_study_module4.dto.CustomerInUsing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerInUsingService {
    List<CustomerInUsing> getList(int page, int size);

}
