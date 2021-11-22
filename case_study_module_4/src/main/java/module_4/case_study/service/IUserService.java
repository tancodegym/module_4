package module_4.case_study.service;

import module_4.case_study.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUserName(String username);
    User findById(Long id);

    void update(User user);

    List<User> searchByUserName(String usename);

    List<User> findAll();

    void addAdmin(Long userId, Long roleId,Long roleId1);

    void addUser(Long userId,Long roleId);
}
