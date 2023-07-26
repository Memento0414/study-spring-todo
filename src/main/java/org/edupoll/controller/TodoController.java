package org.edupoll.controller;

import java.util.List;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.service.QuestService;
import org.edupoll.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TodoService todoService;

	@Autowired
	QuestService questService; // 서버스를 여러 개 사용할 수 있음

	@GetMapping
	public String gotoTodolist(@SessionAttribute String logonUser, ModelMap model) {
		List<Todo> todos = todoService.getTodos(logonUser);
		List<Quest> quests = questService.getThisWeekQuest();
		logger.debug("quest = {}", quests);
		model.put("todos", todos);
		model.put("quests", quests);

		return "todos/list";
	}

	@GetMapping("/create")
	public String gotoCreateTodoView() {

		return "todos/create";
	}

	// 전달되는 값들을 Todo 객체로 받는다고 설정이 전달받은 debug 레벨로 출력
	@PostMapping("/create-task")
	public String handleCreateTodo(@Valid Todo todo, BindingResult result, Model model,
			@SessionAttribute String logonUser) {

//		logger.debug("injected Todo = {}, {}", todo.getDescription(), todo.getTargetDate());

		if (result.hasErrors()) {
			model.addAttribute("message", "목표 날짜와 목표를 반드시 기입해 주시길 바랍니다.");
			return "todos/create";
		} else {

			boolean rst = todoService.addNewTodo(todo, logonUser);

			if (rst) {
				return "redirect:/todos";
			} else {

				return "todos/create";
			}

		}
	}

	@GetMapping("/delete")
	public String handleDeleteTodo(@RequestParam String todoId, @SessionAttribute String logonUser) {

		boolean rst = todoService.removeTodo(todoId, logonUser);

		if (rst) {
			return "redirect:/todos";
		} else {
			return "/fail";
		}
	}

	@GetMapping("/update")
	public String gotoUpdateView(@RequestParam String todoId, ModelMap model) {

		Todo todo = todoService.getTodo(todoId);
		model.addAttribute("todo", todo);

		return "todos/update";
	}

	@PostMapping("/update-task")
	public String handleUpdateTodo(@Valid Todo todo, BindingResult result, ModelMap model,
			@SessionAttribute String logonUser) {

		if (result.hasErrors()) {
			model.addAttribute("todo", todo);
			model.addAttribute("error", " 유효하지 않는 데이터가 포함되어 있다.");
			return "todos/update";
		} else {
			boolean rst = todoService.updateTodo(todo, logonUser);

			if (rst) {
				return "redirect:/todos";
			} else {
				model.addAttribute("todo", todo);
				model.addAttribute("error", "서비스 장애로 실패하였습니다. 다시 시도 해주세요.");
				return "todos/update";
			}
		}

	}

	@GetMapping("/addQuest")
	public String handleQuest(@RequestParam int questId, @SessionAttribute String logonUser) {
		
		boolean result = todoService.acceptNewQuest(questId, logonUser);
		if(result) {
			
			return "redirect:/todos";
			
		} else {
			
			return "fail";
		}
	}
}
