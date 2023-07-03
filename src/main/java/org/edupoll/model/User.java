package org.edupoll.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
	
	@NotBlank
	@NotNull
	@Pattern(regexp ="[a-z][a-z0-9]+")
	@Size(min=3)
	String id;
	
	
	@NotBlank(message="공백을 넣을 수가 없다.")
	@NotNull(message="비밀번호 입력해라")
	@Size(min=3)
	String password;

	public User() {
		super();
	}

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
