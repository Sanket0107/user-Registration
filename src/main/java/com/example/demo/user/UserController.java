package com.example.demo.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public String userRegistration(@RequestBody UserDto dto, HttpServletRequest request) {
		log.info("user registration : {}", dto.toString());
		return service.userRegistration(dto, request);

	}

	@PostMapping("/login")
	public String login(@RequestBody LoginDto dto) {
		log.info("login user by dto : {}", dto.toString());
		return service.login(dto);

	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/get-all")
	public List<User> getAllUsers() {
		log.info("get all users");
		return service.getAll();
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam String email) {
		log.info("delete user by email");
		service.deleteByEmail(email);
	}
}
