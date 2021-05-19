package com.example.cuongstarterkit.application.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user-activities")
public class UserActivityController {

    @GetMapping
    public String getUserActivities() {
        return "user-activities/list-activities";
    }

}
