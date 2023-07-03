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
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuestService {

	@Autowired
	QuestRepository questRepository;
	
	@Autowired
	TodoRepository todoRepository;
	
	public List<Quest> getThisWeekQuest(){
		
		List<Quest> list = questRepository.findAll();
		
		return list;
	}
	
	@Transactional
	public boolean findbyId(int questId, String logonUser) {
		Quest quest = questRepository.findById(questId);
		List<Todo> todos = todoRepository.findByOwner(logonUser);
		System.out.println("quest  " +quest.toString());
		System.out.println("todos " + todos.toString());
		
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
