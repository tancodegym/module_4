package module_4.case_study.repository;

import module_4.case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    List<User> findByUserNameContaining(String username);
}
