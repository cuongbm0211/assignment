package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("listRoles", roleService.listRoles());

        return "role/list-roles";
    }

}
