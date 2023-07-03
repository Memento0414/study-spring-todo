package org.edupoll.service;

import org.edupoll.model.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public boolean createUser(User user) {
		
		User found = userRepository.findById(user.getId());
		
		if(found == null) {
			userRepository.create(user);
			return true;
			
		}else {
			
			return false;
		}
		
	}
	public boolean checkUser(User user) {
		
		User found = userRepository.findById(user.getId());
		
		if(found.getId().equals(user.getId()) && found.getPassword().equals(user.getPassword())) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}
}
