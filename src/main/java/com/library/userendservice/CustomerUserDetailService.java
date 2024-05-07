package com.library.userendservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private Endrepo endrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Endperson person=endrepo.findByEmail(username);
		if(person==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		List<GrantedAuthority>authorities=new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPassword(), authorities);
		
	}

}
