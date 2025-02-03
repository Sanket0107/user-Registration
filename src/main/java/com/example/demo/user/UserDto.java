package com.example.demo.user;

import lombok.Data;

@Data
public class UserDto {

	private String name;

	private String email;

	private String gender;

	private String password;
	
	private String role;
	
	private String ipAddress;
	
	private String country;
}
