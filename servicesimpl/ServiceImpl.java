package com.capstone.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.User;
import com.capstone.error_handling.ResourceNotFoundException;
import com.capstone.iservice.IService;
import com.capstone.repo.UserRepo;

@Service
public class ServiceImpl implements IService {

	@Autowired
	UserRepo userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String deleteUser(int userId) {
		if (getUserById(userId) != null) {
			userRepository.deleteById(userId);
			return "deleted succesfully!";
		} else {
			return "not found!";
		}

	}

	@Override
	public User findByEmail(String email) {
		User u = userRepository.findByEmail(email);
		if (u != null) {
			return u;
		} else {
			throw new ResourceNotFoundException("No contestent with this mail ID " + email);
		}

	}

	@Override
	public String updateUserPassword(String email, User updatedUser) {
		User u = findByEmail(email);
		if (u != null) {
			u.setPassword(updatedUser.getPassword());
			return "Pasword updated!!";
		} else {
			return "Not found, Try Again!!";
		}
	}

}
