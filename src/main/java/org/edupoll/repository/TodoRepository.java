package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.Todo;
import org.springframework.stereotype.Repository;


public interface TodoRepository {
	//데이터 삽입
	public abstract void create(Todo todo);
	//데이터 검색(아이디)
	public abstract  Todo findById(String id);
	
	public abstract  List<Todo> findByOwner(String owner);

	public abstract void deleteById(String id);
	
	public abstract void update(Todo todo);
	
}
