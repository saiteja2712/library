package com.library.Controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.superservice.*;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;
import com.library.PowerService.Powerinterface;
import com.library.Response.AuthResponse;
import com.library.book.Book;
import com.library.bookrepo.BookRepo;
import com.library.config.JwtProvider;
import com.library.entity.Power;
import com.library.loginRequest.LoginRequest;
import com.library.powerRepository.PowerRepo;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;


@RestController
@RequestMapping("/auth/super")
public class AuthsuperController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Powerinterface power;
	@Autowired
	private PowerRepo powerRepo;
	@Autowired
	private Superinterface superinter;
	@Autowired
	private Superimpl superImpl;
	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private CustomerUserDetailsService customerUserDetails;
	@Autowired
	private Endrepo endrepo;
	@Autowired 
	private Endpersoninterface endinter;
	@Autowired
	private BookRepo bookRepo;

	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest)
	{
		UserDetails u=customerUserDetails.loadUserByUsername(loginRequest.getEmail());
		Super sup=superRepo.findByEmail(loginRequest.getEmail());
		if(sup==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Login Success");
		sup.setToken(token);
		superRepo.save(sup);
		System.out.println(token);
//		List<GrantedAuthority>authorities=new ArrayList<>();
//		return new org.springframework.security.core.userdetails.User(sup.getEmail(),sup.getPassword(), authorities);

		return res;
	}
	@PostMapping("/addbook")
	public Book bookadd(@RequestBody Book book,@RequestHeader("Authorization")String jwt)
	{
		Super sup=superinter.findUserByJwt(jwt);
		String var=sup.getToken();
		System.out.println(var);
		if(jwt.substring(7).equals(var)) {
		Book books=new Book();
		return bookRepo.save(book);
		}
		else {
			return null;
		}
		
	}
	@PostMapping("/enduser/signup")
    public AuthResponse Createenduser (@RequestHeader("Authorization")String jwt, @RequestBody Endperson endperson) throws Exception
	{
		Super sup=superinter.findUserByJwt(jwt);
		System.out.println("jwt "+jwt.substring(7));
		//Super supe=superinter.findUserByJwt(jwt);
		String var=sup.getToken();
		System.out.println(var);
		if(jwt.substring(7).equals(var)) {
			System.out.println("valid" + var );
			Power isExistPower = powerRepo.findByEmail(endperson.getEmail());
	        if (isExistPower != null) {
	            throw new Exception("Email already used with another account");
	        }
			 Super spl = superRepo.findByEmail(endperson.getEmail());
		        if (spl != null) {
		            throw new Exception("Email already used with another account");
		        }
		
		Endperson isExist=endrepo.findByEmail(endperson.getEmail());
		if(isExist!=null)
		{
			throw new Exception("email already used with another account");
			
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
		else {
			return null;
		}
		
	}
	
//	@GetMapping("/enduser/find")
//	public ResponseEntity<List<Endperson>> getall(@RequestHeader("Authorization")String jwt,@RequestBody List<Endperson> endPerson) throws Exception
//	{
//		if(superImpl.validateToken(jwt)) 
//		{
//			superinter.findendusers(endPerson);
//			return new ResponseEntity<List<Endperson>>(endPerson,HttpStatus.OK);
//		}
//		else {
//			throw new Exception("invalid token");
//		}
//	}
//	@GetMapping("/enduser/find")
//	public ResponseEntity<Super> getall(@RequestHeader("Authorization")String jwt,@RequestBody List<Endperson> endPerson) throws Exception
//	{
//		Super sup=superinter.findUserByJwt(jwt);
//		if(superImpl.validateToken(jwt)) 
//		{
//			superinter.findendusers(endPerson);
//			return new ResponseEntity<List<Super>>(endPerson,HttpStatus.OK);
//		}
//		else {
//			throw new Exception("invalid token");
//		}
//	}
	@GetMapping("/endusers")
	public List<Endperson> getendusers(@RequestHeader("Authorization")String jwt)
	{
		Super sup=superinter.findUserByJwt(jwt);
		String var=sup.getToken();
		System.out.println(var);
		if(jwt.substring(7).equals(var))
		{
		List<Endperson>sups=endrepo.findAll();
			
		return sups;
	}
		else {
			return null;
		}
	}
//	@GetMapping("/getall")
//	public ResponseEntity<List<Super>>endtotal(@RequestHeader("Authorization")String jwt,@RequestBody Endperson endperson)
//	{
//		Super sup=superinter.findUserByJwt(jwt);
//		String var=sup.getToken();
//		if(jwt.substring(7).equals(var))
//		{
//			List<Super>sups=superinter.findUserByJwt(jwt);
//			return new ResponseEntity<List<Super>>(sups,HttpStatus.OK);
//		}
//		else
//		{
//			return null;
//		}
//	}
//		//Endperson endp=endinter.findUserByJwt(jwt);
		//List<Super>supe=superinter.getall(endp.getId());
		//return new ResponseEntity<List<Super>>(supe,HttpStatus.OK);
		
	
	//}/
//	@GetMapping("/endget")
//	public ResponseEntity<List<Endperson>>findall(@RequestHeader("Authorization")String jwt) throws Exception
//	{
//		Super supp=superinter.findUserByJwt(jwt);
//		String var=supp.getToken();
//		if(jwt.substring(7).equals(var))
//		{
//		List<Endperson>end=endinter.findallendusers(supp.getId());
//		return new ResponseEntity<List<Endperson>>(end,HttpStatus.OK);
//		
//	}
//		else {
//			return null;
//		}
//	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id,@RequestHeader("Authorization")String jwt)
	{
		Super sup=superinter.findUserByJwt(jwt);
		String var=sup.getToken();
		System.out.println(var);
		if(jwt.substring(7).equals(var)) {
		
		endinter.deletebyid(id);
		return "deleted successfully";
	}
		else {
			return null;
		}
	}
		
	@PostMapping("/enduser/signup/{superid}")
	public ResponseEntity<String>Createendperson(@PathVariable int superid,@RequestBody Endperson endperson,@RequestHeader("Authorization")String jwt) throws Exception
	{	
		Super sup=superinter.findUserByJwt(jwt);
		Endperson isExist=endrepo.findByEmail(endperson.getEmail());
		if(isExist!=null)
		{
			throw new Exception("email already used with another account");
			
		}
//		Endperson end=new Endperson();
//		end.setFirstname(endperson.getFirstname());
//		end.setLastname(endperson.getLastname());
//		end.setEmail(endperson.getEmail());
//		end.setPassword(passwordEncoder.encode(endperson.getPassword()));
		Endperson saveduser=superinter.Createenduser(endperson, superid);
		//Endperson updatedSuperAdmin=superinter.Createenduser(endperson, superid);
		
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
	//@GetMapping("/enduser/{superid}")
	//public ResponseEntity<Super>findendperson(@PathVariable int superid,@RequestBody Endperson endperson,@RequestHeader("Authorization")String jwt) throws Exception
	//{	
//		Super sup=superinter.findUserByJwt(jwt);
//		Endperson isExist=endrepo.findByEmail(endperson.getEmail());
//		if(isExist!=null)
//		{
//			throw new Exception("email already used with another account");
//			
//		}
       // Super updatedSuperAdmin = superinter.Createenduser(endperson, superid);
//		Endperson enduser=new Endperson();
//		enduser.setFirstname(endperson.getFirstname());
//		enduser.setLastname(endperson.getLastname());
//		enduser.setEmail(endperson.getEmail());
//		enduser.setPassword(passwordEncoder.encode(endperson.getPassword()));
//		Endperson saveduser=endrepo.save(enduser);
//		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getEmail() ,saveduser.getPassword());

        //return new ResponseEntity<Super>(updatedSuperAdmin, HttpStatus.OK);
    //}
	//sas.addEndUserToSuperAdmin(superAdminId, endperson);
//	
//	public List<Endperson>getAllUsersByAdminToken(@RequestHeader("Authorization")String jwt)
//	{
//		return superinter.getAllUsersByAdminToken(jwt);
//		
//	}
//	@GetMapping("/admin/users/{superid}")
//	public ResponseEntity<List<Super>> getUsersByAdminId(@PathVariable int superid) {
//        Optional<Super> users = superRepo.findById(superid);
//        return ResponseEntity.ok(users);
//    }
	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails=customerUserDetails.loadUserByUsername(email);
		if(userDetails==null)
		{
			throw new BadCredentialsException("Invalid username");
		}
		if(!passwordEncoder.matches(password,userDetails.getPassword()))
		{
			throw new BadCredentialsException("password not matched");
			
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}
	
	

}
