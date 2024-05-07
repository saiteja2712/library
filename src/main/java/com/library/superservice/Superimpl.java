package com.library.superservice;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.library.book.Book;
import com.library.bookrepo.BookRepo;
import com.library.config.JwtProvider;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
//import com.library.userendservice.Endpersoninterface;
@Service
public class Superimpl implements Superinterface {

	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private Endrepo endrepo;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Autowired 
	private BookRepo bookRepo;
//	@Autowired 
//	private Endpersoninterface endinter;
	@Override

	
	public Super findByEmail(String email) {
		// TODO Auto-generated method stub
		return superRepo.findByEmail(email);
	}

	@Override
	public Super findUserByJwt(String jwt) {
		// TODO Auto-generated method stub
		String email=JwtProvider.getEmailFromJwtToken(jwt);
		Super sup=superRepo.findByEmail(email);
		return sup;
	}
	


	@Override
	public Endperson Createenduser(Endperson endperson, int superid) {
		// TODO Auto-generated method stub
		
		Super superAdmin = superRepo.findById(superid)
                .orElseThrow(() -> new RuntimeException("Super admin not found with ID: " + superid));
		
//		superAdmin.getEndperson().add(endperson);
		Endperson end=new Endperson();
		end.setSup(superAdmin);
		end.setFirstname(endperson.getFirstname());
		end.setLastname(endperson.getLastname());
		end.setEmail(endperson.getEmail());
		end.setPassword(passwordEncoder.encode(endperson.getPassword()));
//		//Super sup = new Super();
		
//		superAdmin.setFirstname(endperson.getFirstname());
//		superAdmin.setLastname(endperson.getLastname());
//		superAdmin.setEmail(endperson.getEmail());
//		superAdmin.setPassword(passwordEncoder.encode(endperson.getPassword()));
//		System.out.println(superAdmin.getPassword());
		return endrepo.save(end);
	}
	public Optional<Super> endtotal(Endperson endperson, int superid)
	{
		Super sup=superRepo.findById(superid)
				.orElseThrow(()->new RuntimeException("not available"));
		Optional<Super>sups=superRepo.findById(superid);
		return sups;
		
	}

	@Override
	public Optional<Super> findById(int superid) throws Exception {
		// TODO Auto-generated method stub
		Optional<Super> Opt=superRepo.findById(superid);
		if(Opt.isEmpty())
		{
			throw new Exception("not found");
		}
		return Optional.empty();
	}




	

//	public Endperson findusers(Endperson endperson,String jwt)
//	{
//		Endperson endpers=endinter.findUserByJwt(jwt);
//		
//		return endpers;
////		 return superRepo.findById(superid);
//		
//	}

	public boolean validateToken(String token) {
		return token!=null && !token.isEmpty();
	}

	@Override
	public List<Super> findendusers(int superid) {
		// TODO Auto-generated method stub
		return superRepo.findAll();
	}

	@Override
	public Super Createbook(Book book, int superid) {
		// TODO Auto-generated method stub
		Super superAdmin = superRepo.findById(superid)
                .orElseThrow(() -> new RuntimeException("Super admin not found with ID: " + superid));
		book.setSup(superAdmin);
		superAdmin.getBook().add(book);
		return superRepo.save(superAdmin);
	}
	public Optional<Super> getendpersonsbysuperid(Super req){
		
		Super supr=new Super();
		supr.setId(req.getId());
		Integer id=supr.getId();
		Optional<Super>enddata=superRepo.findById(id);
		return enddata;
	}

	@Override
	public Super findSuperuserByid(int id) throws Exception {
		Optional<Super>supe=superRepo.findById(id);
		if(supe.isPresent())
		{
			return supe.get();
		}
		// TODO Auto-generated method stub
		throw new Exception("not found");
	}

	@Override
	public void addbook(String title, String author, String publisher, MultipartFile image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Super> getall() {
		// TODO Auto-generated method stub
		
		return superRepo.findAll();
	}

	
	



	


//	@Override
//	public List<Super> getall(int id) {
//		// TODO Auto-generated method stub
//		return superRepo.findBySuperAdminId(id);
//	}

	

}
