package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.services.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user-activities")
public class UserActivityController {

    @Autowired
    UserActivityService userActivityService;

    @GetMapping
    public String getUserActivities(Model model) {
        model.addAttribute("listActivities", userActivityService.listUserActivities());
        return "user-activities/list-activities";
    }

}
