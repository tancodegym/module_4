package case_study_module4.service.impl;

import case_study_module4.model.User;
import case_study_module4.repository.IUserRepository;
import case_study_module4.service.IUserService;
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
        iUserRepository.save(user);
    }

    @Override
    public List<User> searchByUserName(String usename) {
        return iUserRepository.findByUserNameContaining(usename);
    }
}
