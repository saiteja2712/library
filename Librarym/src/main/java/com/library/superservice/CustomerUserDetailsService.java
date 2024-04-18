package com.library.superservice;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private SuperRepo superRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Super sup=superRepo.findByEmail(username);
		System.out.println(username);
		if(sup==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		List<GrantedAuthority>authorities=new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(sup.getEmail(),sup.getPassword(), authorities);
		// TODO Auto-generated method stub
	
	}

}
