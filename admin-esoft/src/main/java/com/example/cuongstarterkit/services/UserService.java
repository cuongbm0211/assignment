package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;
import java.util.List;

public interface UserService {

    List<User> listUsers();

    User findByUserName(String username);

    void create(User user);
}
