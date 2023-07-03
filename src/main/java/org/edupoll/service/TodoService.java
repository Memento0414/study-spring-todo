package org.edupoll.service;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.repository.QuestRepository;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	QuestRepository questRepository;

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

	public List<Todo> getTodos(String logonUser) {

		List<Todo> list = todoRepository.findByOwner(logonUser);

		for (Todo todo : list) {
			if (todo.getTargetDate().getTime() - System.currentTimeMillis() < 1000L * 60 * 60 * 24 * 2) {
				todo.setWarning(true);
			}
		}
		return list;
	}

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

}
