package module_4.case_study.service.impl;

import module_4.case_study.model.User;
import module_4.case_study.repository.IUserRepository;
import module_4.case_study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return iUserRepository.findByUserName(username);
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public void update(User user) {
        User user1= user;
        System.out.println(user1);
        iUserRepository.save(user);
    }

    @Override
    public List<User> searchByUserName(String usename) {
        return iUserRepository.findByUserNameContaining(usename);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void addAdmin(Long userId, Long roleId,Long roleId1) {
        iUserRepository.addAdmin(userId,roleId,roleId1);
    }

    @Override
    public void addUser(Long userId, Long roleId) {
        iUserRepository.addUser(userId,roleId);
    }
}
