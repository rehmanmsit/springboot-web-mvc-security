package com.rehmanmsit.controller.vo;

import lombok.Data;

/**
 *
 * @author Rehman
 *
 */

@Data
public class InitialPostRequestVO {

	private String name;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	private String designation;

}
