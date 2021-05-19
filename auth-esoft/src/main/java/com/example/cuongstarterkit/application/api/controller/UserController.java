package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.application.api.dto.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/api/v1/users/me")
    public ResponseEntity<UserProfile> profile()
    {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = principal.getUsername();

        UserProfile profile = new UserProfile();
        profile.setName(principal.getUsername());
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    }
}
