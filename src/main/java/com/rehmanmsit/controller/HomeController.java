package com.rehmanmsit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;
import com.rehmanmsit.repository.UserRepository;
import com.rehmanmsit.repository.entity.Role;
import com.rehmanmsit.repository.entity.User;

/**
 *
 * @author Rehman
 *
 */

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@GetMapping(value = {"/", "/home"})
	public String getHome() {
		return "index";
	}

	@PostMapping(value = "/register")
	@ResponseBody
	public Map<String, String> handleInitialPostRequest(@ModelAttribute InitialPostRequestVO initialPostRequestVO) {
		Map<String, String> resp = new HashMap<String, String>();
		User user = populateAndSaveUser(initialPostRequestVO);
		if(null != user) {
			resp.put("status", "1");
		} else {
			resp.put("status", "0");
		}
		return resp;
	}
	
	private User populateAndSaveUser(InitialPostRequestVO request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setDesignation(request.getDesignation());
		user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		user.setRole(Role.USER);
		return userRepo.save(user);
	}

	@GetMapping("/getUsers")
	@ResponseBody
	public List<User> getUser() {
		return userRepo.findAll();
	}

}
