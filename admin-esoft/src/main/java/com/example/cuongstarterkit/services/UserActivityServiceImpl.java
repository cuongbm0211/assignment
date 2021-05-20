package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;
import com.example.cuongstarterkit.db.jpa.entities.UserActivity;
import com.example.cuongstarterkit.db.jpa.repositories.UserActivityRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    UserActivityRepository userActivityRepository;

    @Override
    public List<UserActivity> listUserActivities() {
        return userActivityRepository.findAll();
    }
}
