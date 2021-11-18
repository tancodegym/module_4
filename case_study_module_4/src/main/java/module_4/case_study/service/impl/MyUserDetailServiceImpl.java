package module_4.case_study.service.impl;

import module_4.case_study.model.MyUserDetail;
import module_4.case_study.model.User;
import module_4.case_study.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl
        implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found !");
        }
        MyUserDetail myUserDetail = new MyUserDetail(user);
        return myUserDetail;
    }
}
