package com.miPortfolio.server.security.service;

import com.miPortfolio.server.security.entity.User;
import com.miPortfolio.server.security.repository.IUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public Optional<User> getByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }

    public boolean existsByUserName(String userName) {
        return iUserRepository.existsByUserName(userName);
    }

    public boolean existsByEmail(String email) {
        return iUserRepository.existsByEmail(email);
    }
    
    public void save(User user){
        iUserRepository.save(user);
    }
}
