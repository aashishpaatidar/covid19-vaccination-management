package io.covid19vms.service;

import io.covid19vms.entity.User;
import io.covid19vms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUserDetails(User user) {
        return userRepo.save(user);
    }
}
