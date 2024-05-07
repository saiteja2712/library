package com.library.config;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.library.superentity.Super;
import com.library.superservice.Superinterface;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter{

	@Autowired
	private Endpersoninterface endinter;
	@Autowired
	private Superinterface superinter;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt=request.getHeader(JwtConstant.JWT_HEADER);
		// TODO Auto-generated method stub
		
		if(jwt!=null)
//		{
			try {
				String email=JwtProvider.getEmailFromJwtToken(jwt);
				List<GrantedAuthority>authorities=new ArrayList<>();
				
				Authentication authentication=new UsernamePasswordAuthenticationToken(email,null,authorities);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				
			}
//	}
		filterChain.doFilter(request, response);
		
			
		
	}

}
