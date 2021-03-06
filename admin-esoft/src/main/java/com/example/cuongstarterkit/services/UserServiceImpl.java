package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;
import com.example.cuongstarterkit.db.jpa.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findByUserName(String username) {
        User user = userRepo.findByUsername(username);

        return user;
    }

    @Override
    public void create(User user) {
        userRepo.save(user);
    }
}
