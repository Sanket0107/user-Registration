package com.example.demo.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	
	public String userRegistration(UserDto dto,HttpServletRequest request);
	
	public String login(LoginDto dto);
	
	public String deleteByEmail(String email);
	
	public List<User> getAll();
}
