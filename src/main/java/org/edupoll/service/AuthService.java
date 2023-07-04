package org.edupoll.service;

import org.edupoll.model.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	/**회원가입 메서드*/
	public boolean createUser(User user) {
		
		User found = userRepository.findById(user.getId());
		
		if(found == null) {
			userRepository.create(user);
			return true;
			
		}else {
			
			return false;
		}
		
	}
	/**로그인시 유저테이블에 데이터가 확인하는 작업*/
	public boolean checkUser(User user) {
		
		User found = userRepository.findById(user.getId());
		
		if(found.getId().equals(user.getId()) && found.getPassword().equals(user.getPassword())) {
			
			return true;
			
		} else {
			
			return false;
		}
		
	}
}
