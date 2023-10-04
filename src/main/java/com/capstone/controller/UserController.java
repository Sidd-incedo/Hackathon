package com.capstone.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.User;
import com.capstone.repo.UserRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/hackathon/users")
public class UserController {
//	code this :)
	
	@Autowired
    private UserRepo ur;//change it with user service later for now its just repo

	//secure it
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User registrationRequest) {
        // role confirmation from admin
        ur.save(registrationRequest);
        return ResponseEntity.ok("User registered successfully.");
    }

    //secure it & encrypt pw
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        // Implement user login logic here
//        String token = ur.loginUser(loginRequest);
        User curr_user=ur.findByEmail(loginRequest.getEmail());
                
        if(curr_user.getPassword().equals(loginRequest.getPassword()))
        {
        	 return ResponseEntity.ok(loginRequest.toString());
        }
        else
        {
            return ResponseEntity.badRequest().body("Invalid credentials");

        }
        
    }

    //admin use
    @GetMapping("/admin/{userId}")
    public ResponseEntity<Optional<User>> getUserProfile(@PathVariable int userId) {
        Optional<User> user = ur.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/admin/{userId}")
    public ResponseEntity<String> updateUserProfile(@PathVariable int userId, @RequestBody User updatedUser) {
        // Implement logic to update user profile by userId
    	
//    	User u = ur.getById(userId);
//            u.se
//        ur.updateUserProfile(userId, updatedUser);
    	
    	updatedUser.setuId(userId);
    	ur.save(updatedUser);
        return ResponseEntity.ok("User profile updated successfully.");
    }


}
