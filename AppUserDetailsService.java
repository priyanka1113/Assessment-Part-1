package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.AppUserDetails;
import com.priyanka.model.User;
import com.priyanka.repository.UserRespository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRespository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findbyemail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUserDetails(user);
	}

}
