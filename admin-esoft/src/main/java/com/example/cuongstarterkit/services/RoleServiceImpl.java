package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.Role;
import com.example.cuongstarterkit.db.jpa.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }
}
