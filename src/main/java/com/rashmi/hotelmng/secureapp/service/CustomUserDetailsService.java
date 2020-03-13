package com.rashmi.hotelmng.secureapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rashmi.hotelmng.secureapp.models.CustomUserDetails;
import com.rashmi.hotelmng.secureapp.models.User;
import com.rashmi.hotelmng.secureapp.repository.HomeRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = homeRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		return new CustomUserDetails(user);

}
}
