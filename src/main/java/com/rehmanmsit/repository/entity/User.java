package com.rehmanmsit.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 *
 * @author Rehman
 *
 */

@Document
@Data
public class User {

	@Id
	private String id;

	private String name;
	
	private String email;
	
	private String password;
	
	private String designation;

	private Role role;

}
