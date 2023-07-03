package org.edupoll.repository;
import org.edupoll.model.User;

public interface UserRepository {

	public void create(User user);

	public User findById(String id);
}
