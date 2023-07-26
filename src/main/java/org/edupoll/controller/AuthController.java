package org.edupoll.controller;

import org.edupoll.model.User;
import org.edupoll.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;

@Controller
public class AuthController {

	@Autowired
	AuthService authService;

	@GetMapping("/auth")
	public String gotoLoginView(Model model) {

		return "auth";
	}
	//뷰로 이동하는 메소드
	@GetMapping("/user/join")
	public String joinHandle() {
		
		return "/user/join";
	}
	//회원가입시 유효성 검사 후 제약조건에 맞는 것만 넘기는 메서드
	@PostMapping("/user/join-task")
	public String joinTaskHandle(@Valid User user, BindingResult result, Model model) {
		
		boolean rst = authService.createUser(user);
		
		if (result.hasErrors()) {
			
			model.addAttribute("error", "유효하지 않은 아이디와 비밀번호입니다.");
			
			return "user/join";

		} else {

			if (rst) {

				return "auth";
				
			} else {
				
				model.addAttribute("error", "이미 가입된 아이디입니다.");
				
				return "user/join";
			}

		}
	}
	//로그인시 DB에 있는 데이터와 사용자가 입력한 데이터가 일치하는 확인하는 메서드
	@PostMapping("/auth-task")
	public String checkUserHandle(User user, HttpSession session, Model model) {
		boolean rst = authService.checkUser(user);

		if (rst) {
			session.setAttribute("logonUser", user.getId());
			return "redirect:/todos";
		} else {
			model.addAttribute("error", "아이디와 비밀번호가 일치하지 않습니다.");
			return "/auth";

		}

	}
	
	//로그인 성공시 로그아웃 기능을 담당하는 메서드
	@GetMapping("/auth-out")
	public String logOut(HttpSession session) {
		
		session.invalidate();
		
		return "/auth";
		
	}
}
