package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;
import com.example.cuongstarterkit.db.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User findByUserName(String username) {
        User user = userRepo.findByUsername(username);

//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }

        return user;
    }
}
