package com.example.demo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "password")
	private String password;
	
	@Column(name = "ipAddress")
	private String ipAddress;
	
	@Column(name = "role")
	private String role;
	
	@Lob
	@Column(name = "country")
	private String country;
	
	public User(Long id) {
		super();
		this.id = id;
	}
}
