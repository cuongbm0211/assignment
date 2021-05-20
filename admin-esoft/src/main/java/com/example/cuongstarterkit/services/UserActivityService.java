package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.UserActivity;
import java.util.List;

public interface UserActivityService {

    List<UserActivity> listUserActivities();

}
