package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Roles;
@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}
