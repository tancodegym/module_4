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
        iUserRepository.save(user);
    }

    @Override
    public List<User> searchByUserName(String usename) {
        return iUserRepository.findByUserNameContaining(usename);
    }
}
