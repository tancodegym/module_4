package module_4.case_study.repository;

import module_4.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee e join  `user` u on e.`user` = u.id where e.code like :code and e.`name` like :name and e.birth_date like :birthDay and address like :address and salary like :salary and email like :email and id_card like :idCard and division like :division and education_degree like :educationDegree and position_id like :position and phone like :phone and user_name like :username", nativeQuery = true)
    Page<Employee> searchAll(Pageable pageable, @Param("code") String code, @Param("name") String name, @Param("birthDay") String birthDay,
                             @Param("idCard") String idCard, @Param("salary") String salary, @Param("phone") String phone,
                             @Param("email") String email, @Param("address") String address, @Param("position") String position,
                             @Param("educationDegree") String educationDegree, @Param("division") String division,@Param("username") String username);


}
