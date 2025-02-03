package com.example.demo.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GetIPGeoBase getIPGeoBase;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String userRegistration(UserDto dto, HttpServletRequest request) {
		User exitstingUser = userRepository.findByEmail(dto.getEmail());
		if (exitstingUser != null) {
			return "User already exists with this email";
		}
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setGender(dto.getGender());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());

		// get ip and country
		user.setIpAddress(request.getRemoteAddr());
		String country = getIPGeoBase.getCountryNameByIP(request.getRemoteAddr());
		user.setCountry(country);
		userRepository.save(user);
		return "successfully saved";
	}

	@Override
	public String login(LoginDto dto) {
		AuthenticationManager authenticationManager=null;
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		User user = userRepository.findByEmail(dto.getEmail());
		if (user != null) {
			 boolean isMatchPassword =  passwordEncoder.matches(dto.getPassword(), user.getPassword());
			 if(isMatchPassword){
				 return "Login success";
			 }
			 return "Invalid password";
		}
		return "User not found";
		

	}

	@Override
	public List<User> getAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public String deleteByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			userRepository.delete(user);
		}
		return "user delete successfully";
	}

}
