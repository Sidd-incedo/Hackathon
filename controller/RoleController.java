package com.capstone.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capstone.entity.Roles;
import com.capstone.error_handling.ResourceNotFoundException;
import com.capstone.repo.RoleRepo;

import java.util.List;

@RestController
@RequestMapping("/hackathon/admin/roles")//ADMIN CONTROLLED
public class RoleController {
    @Autowired
    public RoleRepo roleRepository;

    // Create a new role
    @PostMapping
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    // Get a role by ID
    @GetMapping("/{roleId}")
    public ResponseEntity<Roles> getRoleById(@PathVariable int roleId) {
        Roles role = roleRepository.findById(roleId)
                .orElseThrow();
        return ResponseEntity.ok(role);
    }

    // Get all roles
    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = roleRepository.findAll();
        return ResponseEntity.ok(roles);
    }

    // Update a role by ID
    @PutMapping("/{roleId}")
    public ResponseEntity<Roles> updateRole(@PathVariable int roleId, @RequestBody Roles updatedRole) {
        Roles existingRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with ID: " + roleId));

        existingRole.setRoleName(updatedRole.getRoleName());

        Roles savedRole = roleRepository.save(existingRole);
        return ResponseEntity.ok(savedRole);
    }

    // Delete a role by ID
    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable int roleId) {
        Roles role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with ID: " + roleId));
        roleRepository.delete(role);
        return ResponseEntity.noContent().build();
    }
}
