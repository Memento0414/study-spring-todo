package org.edupoll;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.edupoll.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import oracle.net.ano.AuthenticationService;

@SpringBootTest
class AppTodoApplicationTests {

	
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	AuthenticationService authService;
	
	@Test
	void contextLoads() {
		
		todoRepository.create(new Todo("z1", "master", null, null, null));
		todoRepository.create(new Todo("z2", "user1", null, null, null));
		todoRepository.create(new Todo("z3", "User2", null, null, null));
		
//		Todo findId = todoRepository.findById("z2");
//		System.out.println("findId = " + findId);
//		
//		
//		List<Todo> findOwner = todoRepository.findByOwner("user13");
//		System.out.println("findOwner = " + findOwner);
		
		
		
//		System.out.println("authService = " + authService.isValidate("user", "1q2w3e4r"));
//		System.out.println("authService1 = " + authService.isValidate("test", "1111"));
	}

}
