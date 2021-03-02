package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.priyanka.model.User;
import com.priyanka.repository.UserRespository;

@Controller
public class UserController {
	@Autowired
	private UserRespository repo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/userRegistration")
	public String showSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "signuppage";

	}

	@PostMapping("/processRegistration")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedpassword = encoder.encode(user.getPassword());
		user.setPassword(encodedpassword);
		repo.save(user);
		return "registrationsuccesspage";
	}
}
