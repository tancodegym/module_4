package case_study_module4.repository;

import case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value="select * from customer where code like :code and `name` like :name" +
            " and birth_date like:birthDay and address like :address and gender like :gender" +
            " and email like :email and id_card like :idCard and customer_type_id like :typeCustomer and phone like :phone ",nativeQuery=true)
    Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender,
                             String idCard, String email, String phone, String address, String typeCustomer);
}
