package com.vinay7.SpringSecurityDemo.service;

import com.vinay7.SpringSecurityDemo.entity.Role;
import com.vinay7.SpringSecurityDemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}