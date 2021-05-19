package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.application.api.UserProfile;
import com.example.cuongstarterkit.db.jpa.entities.User;
import com.example.cuongstarterkit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("listUsers", userService.listUsers());

        return "user/list-users";
    }

    @PostMapping
    public String createUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

//        userService.save(user);

        return "user/list-users";
    }

    @RequestMapping("/api/v1/users/me")
    public ResponseEntity<UserProfile> profile()
    {
        //Build some dummy data to return for testing
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = principal.getUsername();

        UserProfile profile = new UserProfile();
        profile.setName(principal.getUsername());
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    }



}
