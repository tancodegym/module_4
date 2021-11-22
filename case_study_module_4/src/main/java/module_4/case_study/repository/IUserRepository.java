package module_4.case_study.repository;

import module_4.case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    List<User> findByUserNameContaining(String username);

    @Transactional
    @Modifying
    @Query(value ="insert into user_role(user_id,role_id) value (:userId,:roleId) ",nativeQuery = true)
    void addUser(@Param("userId")Long userId,@Param("roleId")Long roleId);

    @Transactional
    @Modifying
    @Query(value ="insert into user_role(user_id,role_id) value (:userId,:roleId),(:userId,:roleId1) ",nativeQuery = true)
    void addAdmin(@Param("userId")Long userId,@Param("roleId")Long roleId,@Param("roleId1")Long roleId1);
}
