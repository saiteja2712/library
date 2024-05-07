package com.library.PowerService;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.entity.Power;
import com.library.powerRepository.PowerRepo;
@Service
public class CustomerUserDetailsSevice implements UserDetailsService {

	@Autowired 
	private PowerRepo powerRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Power power=powerRepo.findByEmail(username);
		if(power==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		List<GrantedAuthority>authorities=new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(power.getEmail(),power.getPassword(),authorities);
	}

}
