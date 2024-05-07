package com.library.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Response.AuthResponse;
import com.library.book.Book;
import com.library.bookrepo.BookRepo;
import com.library.config.JwtProvider;
import com.library.loginRequest.LoginRequest;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;
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
	private BookRepo bookrepo;
	@Autowired
	private CustomerUserDetailService customerUserDetails;
	@Autowired
	private Superinterface superinter;
	
	@PostMapping("/enduser/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest)
	{
		UserDetails u=customerUserDetails.loadUserByUsername(loginRequest.getEmail());
		Endperson endperson=endrepo.findByEmail(loginRequest.getEmail());
		if(endperson==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Login success");
		endperson.setToken(token);
		endrepo.save(endperson);
		System.out.println(token);
		return res;
	}
	@GetMapping("/displayall")
	public List<Endperson>findalls(@RequestHeader("Authorization")String jwt) throws Exception
	{
		Super supp=superinter.findUserByJwt(jwt);
		List<Endperson>endperson=endinter.findallendusers(supp.getId());
		return endperson;
		
	}
//	@GetMapping("/admin/{adminId}")
//    public ResponseEntity<List<Endperson>> getUsersByAdminId(@PathVariable int adminId) {
//        List<Endperson> users = endrepo.findBySuperAdminid(adminId);
//        return ResponseEntity.ok(users);
//    }

	@GetMapping("/endget")
	public ResponseEntity<List<Endperson>>findall(@RequestHeader("Authorization")String jwt) throws Exception
	{
	Super supp=superinter.findUserByJwt(jwt);
	String var=supp.getToken();
	System.out.println(var);
	if(jwt.substring(7).equals(var))
	{
		List<Endperson>end=endinter.findallendpersons(supp);
		return new ResponseEntity<List<Endperson>>(end,HttpStatus.OK);
	}
	else {
		return null;
	}
	}
	
//	@PostMapping("/{endpersonid}/assignbook/{bookid}")
//	public ResponseEntity<String> assignBookToEndperson(@PathVariable int endpersonid,@PathVariable int bookid) throws Exception
//	{
//		Endperson endperson=endrepo.findById(endpersonid).orElseThrow(()->new Exception("Endperson not found with id"+endpersonid));
//		Book book=bookrepo.findById(bookid).orElseThrow(()->new Exception ("Book not found"+bookid));
//		if(book.getAssignedToEndperson()!=null)
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book already assigned to another endperson");
//		}
//		
//		endperson.getAssignedBooks().add(book);
//		book.setAssignedToEndperson(null);
//		endrepo.save(endperson);
//		return ResponseEntity.ok("Book assigned successfully");
//	}
//	@PostMapping("/{endpersonid}/releasebook/{bookid}")
//	public ResponseEntity<String>releaseBookFromendperson(@PathVariable int endpersonid,@PathVariable int bookid) throws Exception{
//		Endperson endperson=endrepo.findById(endpersonid).orElseThrow(()->new Exception ("Endperson not found"));
//		Book book=bookrepo.findById(bookid).orElseThrow(()-> new Exception("Book not found"));
//		if(book.getAssignedToEndperson()==null || !book.getAssignedToEndperson().equals(endperson)) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book is not assigned to the endperson");
//		}
//		endperson.getAssignedBooks().remove(book);
//		book.setAssignedToEndperson(null);
//		endrepo.save(endperson);
//		return ResponseEntity.ok("Book released succesfully from endperson");
//		
//	}
//	@GetMapping("/{endpersonid}/assignedbooks")
//	public Set<Book>getAssignedBooksByendperson(@PathVariable int endpersonid) throws Exception
//	{
//		Endperson endperson=endrepo.findById(endpersonid).orElseThrow(()-> new Exception ("Books not at all assigned no books"));
//		return endperson.getAssignedBooks();
//	}
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
