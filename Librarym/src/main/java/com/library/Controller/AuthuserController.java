package com.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Response.AuthResponse;
import com.library.config.JwtProvider;
import com.library.loginRequest.LoginRequest;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.CustomerUserDetailService;
import com.library.userendservice.Endpersoninterface;

@RestController
@RequestMapping("/auth/user")
public class AuthuserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Endpersoninterface endinter;
	@Autowired
	private Endrepo endrepo;
	@Autowired
	private CustomerUserDetailService customerUserDetails;
	
	@PostMapping("/enduser/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest)
	{
		Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Login success");
		return res;
	}
//	@GetMapping("/admin/{adminId}")
//    public ResponseEntity<List<Endperson>> getUsersByAdminId(@PathVariable int adminId) {
//        List<Endperson> users = endrepo.findBySuperAdminid(adminId);
//        return ResponseEntity.ok(users);
//    }

	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails=customerUserDetails.loadUserByUsername(email);
		if(userDetails==null)
		{
			throw new BadCredentialsException("Invalid username");
		}
//		if(!passwordEncoder.matches(password,userDetails.getPassword()));
//		{
//			throw new BadCredentialsException("password not matched");
//		}
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}

}
