package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.enums.ActivityType;

public interface UserActivityService {

    void logActivity(String username, ActivityType type);

}
