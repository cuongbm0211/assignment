package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.User;
import com.example.cuongstarterkit.db.jpa.entities.UserActivity;
import com.example.cuongstarterkit.db.jpa.repositories.UserActivityRepository;
import com.example.cuongstarterkit.enums.ActivityType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    UserService userService;

    @Autowired
    UserActivityRepository userActivityRepository;

    @Override
    public void logActivity(String username, ActivityType type) {
        User activeUser = userService.findByUserName(username);
        if (username == null) {
            log.info("User not found: " + activeUser);
            return;
        }

        UserActivity userActivity = UserActivity.builder()
            .user(activeUser)
            .activityType(type)
            .build();

        userActivityRepository.save(userActivity);
    }
}
