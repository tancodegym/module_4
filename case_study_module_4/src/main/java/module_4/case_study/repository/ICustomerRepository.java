package module_4.case_study.repository;

import module_4.case_study.dto.CustomerDetail;
import module_4.case_study.dto.CustomerInUsing;
import module_4.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value="select * from customer where code like :code and `name` like :name" +
            " and birth_date like:birthDay and address like :address and gender like :gender" +
            " and email like :email and id_card like :idCard and customer_type_id like :typeCustomer and phone like :phone ",nativeQuery=true)
    Page<Customer> searchAll(Pageable pageable, String code, String name, String birthDay, String gender,
                             String idCard, String email, String phone, String address, String typeCustomer);


    @Query(value="  Select ct.id as contract,s.`code` as service, customer.`code` as customercode,customer.`name` as customername,\n" +
            "cd.quantity as quantity,SUM(s.cost + coalesce(a.cost*cd.quantity,0)) as total, customer.id as customerid\n" +
            "from customer join contract ct on customer.id = ct.customer\n" +
            "join contract_detail cd on cd.contract = ct.id\n" +
            "join attach_service a on a.id = cd.attach_service\n" +
            "join service s on ct.service = s.id\n" +
            "Group by customer.id Order By ct.id limit :page,:size",nativeQuery=true)
    List<CustomerInUsing> getList(@Param("page") int page, @Param("size") int size);



    @Query(value="call get_attach_service_name( :idCustomer)",nativeQuery=true)
    List<CustomerDetail> getDetailCustomer(Long idCustomer);


}
