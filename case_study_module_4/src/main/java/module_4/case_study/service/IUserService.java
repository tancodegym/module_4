package module_4.case_study.service;

import module_4.case_study.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUserName(String username);
    User findById(Long id);

    void update(User user);

    List<User> searchByUserName(String usename);

    List<User> findAll();
}
