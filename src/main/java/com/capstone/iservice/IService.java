package com.capstone.iservice;

import java.util.List;

import com.capstone.entity.User;

public interface IService {
	//common methods
//	User login(User user);
	User createUser(User user);//register
	String updateUserPassword(String email, User updatedUser);
//	void logout();
	
	//Admin methods
	List<User> getAllUsers();
	User getUserById(int userId);
	String deleteUser(int userId);
	
	//Leader methods
	User findByEmail(String email);
	void createIdea();
	void updateIdea();
	void deleteIdea();
	void addImplementaion();
	
	//Team members methods- can only update password no other method
	
	//Panelist methods
	
	
	//Judges methods
	
	
}