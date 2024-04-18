package com.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.PowerService.CustomerUserDetailsSevice;
import com.library.PowerService.Powerinterface;
import com.library.Response.AuthResponse;
import com.library.config.JwtProvider;
import com.library.entity.Power;
import com.library.loginRequest.LoginRequest;
import com.library.powerRepository.PowerRepo;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;

@RestController
@RequestMapping("/auth/power")
public class AuthController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Powerinterface power;
	@Autowired
	private PowerRepo powerRepo;
	@Autowired 
	private CustomerUserDetailsSevice customerUserDetails;
	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private Endrepo endrepo;
	@Autowired
	private Endpersoninterface endinter;
	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest )
	{
		Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Login Success");
		return res;
	}
	@PostMapping("/signup")
	public AuthResponse signup(@RequestBody Power pow) throws Exception
	{
		Power isExist=powerRepo.findByEmail(pow.getEmail());
		if(isExist!=null)
		{
			throw new Exception ("email already used with another account");
		}
		Power superadmin=new Power();
		superadmin.setEmail(pow.getEmail());
		superadmin.setPassword(passwordEncoder.encode(pow.getPassword()));
		superadmin.setRole(pow.getRole());
		Power saveduser=powerRepo.save(superadmin);
		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getEmail() ,saveduser.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Register success");
		
		return res;
	}
	@PostMapping("super/signup")
	public AuthResponse Createsuperuser(@RequestBody Super sup) throws Exception {
		Super isExist=superRepo.findByEmail(sup.getEmail());
		if(isExist!=null)
		{
			throw new Exception ("email already used with another account");
		}
		Super superadmin=new Super();
		superadmin.setFirstname(sup.getFirstname());
		superadmin.setLastname(sup.getLastname());
		superadmin.setEmail(sup.getEmail());
		superadmin.setPassword(passwordEncoder.encode(sup.getPassword()));
		Super saveduser=superRepo.save(superadmin);
		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getEmail() ,saveduser.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Register success");
		
		return res;
		
	}
	@PostMapping("/user/signup")
	public AuthResponse Createenduser(@RequestBody Endperson endperson,@RequestHeader("Authorization")String jwt) throws Exception {
		Power pow=power.findUserByJwt(jwt);
		Endperson isExist=endrepo.findByEmail(endperson.getEmail());
		if(isExist!=null)
		{
			throw new Exception ("email already used with another account");
		}
		Endperson enduser=new Endperson();
		enduser.setFirstname(endperson.getFirstname());
		enduser.setLastname(endperson.getLastname());
		enduser.setEmail(endperson.getEmail());
		enduser.setPassword(passwordEncoder.encode(endperson.getPassword()));
		Endperson saveduser=endrepo.save(enduser);
		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getEmail() ,saveduser.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Register success");
		
		return res;
		
	}
	@GetMapping("/enduser/getall")
	public ResponseEntity<List<Endperson>>findallendusers(@RequestHeader("Authorization")String jwt,Power powers)
	{
		Power pow=power.findUserByJwt(jwt);
		List<Endperson>endperson=endinter.findallendusers(pow.getId());
		
		return new ResponseEntity<List<Endperson>>(endperson,HttpStatus.OK);
		
	}


	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails=customerUserDetails.loadUserByUsername(email);
		if(userDetails==null)
		{
			throw new BadCredentialsException("invalid username");
		}
		if(!password.equals(userDetails.getPassword()))
		{
			throw new BadCredentialsException("password not matched");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}

}
