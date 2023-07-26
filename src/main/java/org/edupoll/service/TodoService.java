package org.edupoll.service;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.repository.QuestRepository;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	QuestRepository questRepository;

	/**할일 일정 생성하는 메서드*/
	public boolean addNewTodo(Todo todo, String logonUser) {

		String id = UUID.randomUUID().toString().split("-")[0];
		Todo found = todoRepository.findById(id);
		if (found == null) {
			todo.setId(id);
			todo.setOwner(logonUser);

			todoRepository.create(todo);
			return true;
		} else {
			return false;
		}
	}
	/**등록된 일정들을 불러오는 메서드*/
	public List<Todo> getTodos(String logonUser) {

		List<Todo> list = todoRepository.findByOwner(logonUser);

		for (Todo todo : list) {
			if (todo.getTargetDate().getTime() - System.currentTimeMillis() < 1000L * 60 * 60 * 24 * 2) {
				todo.setWarning(true);
			}
		}
		return list;
	}
	/**일정을 삭제하는 메서드*/
	public boolean removeTodo(String todoId, String commanderId) {

		Todo todo = todoRepository.findById(todoId);

		if (todo == null) {
			return false;
		}
		if (todo.getOwner().equals(commanderId)) {
			todoRepository.deleteById(todoId);
			return true;
		} else {
			return false;
		}
	}

	public Todo getTodo(String todoId) {

		return todoRepository.findById(todoId);
	}

	public boolean updateTodo(Todo todo, String commandId) {
		Todo found = todoRepository.findById(todo.getId());
		if (found.getOwner().equals(commandId)) {
			todoRepository.update(todo);
			return true;
		}
		return false;

	}
	
	@Transactional
	public boolean acceptNewQuest(int questId, String logonUser) {
		Quest quest = questRepository.findById(questId);
		List<Todo> todos = todoRepository.findByOwner(logonUser);

		
		
		if (todos.stream().filter(t -> {
			return t.getDescription().equals(quest.getDescription());
		}).toList().isEmpty()) {

			Todo todo = new Todo();

			todo.setOwner(logonUser);
			todo.setDescription(quest.getDescription());
			todo.setTargetDate(quest.getEndDate());
			todo.setId(UUID.randomUUID().toString().split("-")[0]);
			todoRepository.create(todo);

			quest.setJoinCnt(quest.getJoinCnt() + 1);
			questRepository.update(quest);

			return true;
			
		} else {
			
			return false;
		}
	}
	
	

}
