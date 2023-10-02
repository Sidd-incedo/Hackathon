package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.User;

import jakarta.transaction.Transactional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Transactional
	User findByEmail(String email);

}
