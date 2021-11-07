package case_study_module4.service;

import case_study_module4.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUserName(String username);
    User findById(Long id);

    void update(User user);

    List<User> searchByUserName(String usename);
}
