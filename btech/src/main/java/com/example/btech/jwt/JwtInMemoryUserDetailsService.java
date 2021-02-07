package com.example.btech.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.btech.entity.BtechCredentialEntity;
import com.example.btech.repo.BtechCredRepo;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	private BtechCredRepo credRepo;
	
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		
		BtechCredentialEntity loggedUserDetails = credRepo.findById(emailId).orElse(null);
		if(null==loggedUserDetails) {
			 throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", emailId));
		}
		
		return new JwtUserDetails(loggedUserDetails.getEmailId(), new BCryptPasswordEncoder().encode(loggedUserDetails.getPassword()), loggedUserDetails.getRole());
	}

 
}
