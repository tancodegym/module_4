package case_study_module4.repository;

import case_study_module4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    List<User> findByUserNameContaining(String username);
}
