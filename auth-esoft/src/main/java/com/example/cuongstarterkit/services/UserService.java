package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;

public interface UserService {

    User findByUserName(String username);

}
