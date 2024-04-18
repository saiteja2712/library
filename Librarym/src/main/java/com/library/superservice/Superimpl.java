package com.library.superservice;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.config.JwtProvider;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
@Service
public class Superimpl implements Superinterface {

	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private Endrepo endrepo;
	@Autowired 
	private PasswordEncoder passwordEncoder;
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
	public Super Createenduser(Endperson endperson, int superid) {
		// TODO Auto-generated method stub
		
		Super superAdmin = superRepo.findById(superid)
                .orElseThrow(() -> new RuntimeException("Super admin not found with ID: " + superid));
		endperson.setSup(superAdmin);
		superAdmin.getEndperson().add(endperson);
		//Super sup = new Super();
		superAdmin.setFirstname(endperson.getFirstname());
		superAdmin.setLastname(endperson.getLastname());
		superAdmin.setEmail(endperson.getEmail());
		superAdmin.setPassword(passwordEncoder.encode(endperson.getPassword()));
		 //Super user=superRepo.save(sup);
//		Endperson enduser=new Endperson();
//		enduser.setFirstname(endperson.getFirstname());
//		enduser.setLastname(endperson.getLastname());
//		enduser.setEmail(endperson.getEmail());
//		enduser.setPassword(passwordEncoder.encode(endperson.getPassword()));
//		Endperson saveduser=endrepo.save(enduser);
		 //return user;
		return superRepo.save(superAdmin);
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

//	@Override
//	public Endperson Createendperson(Endperson endperson) {
//		// TODO Auto-generated method stub
//		return endrepo.save(endperson);
//	}

//	@Override
//	public List<Endperson> getAllUsersByAdminToken(String adminToken) {
//		String adminEmail=extractAdminEmail(adminToken);
//		
//		// TODO Auto-generated method stub
//		return endrepo.findByCreatedByEmail(adminEmail);
//	}
//
//	private String extractAdminEmail(String adminToken) 
//	{
//		
//		// TODO Auto-generated method stub
//		return "admin";
//	}

	

	

	
	
	


	

//	@Override
//	public Endperson Createenduser(Endperson endperson,int superid) {
//		Optional<Super> sup=superRepo.findById(superid);
//		// TODO Auto-generated method stub
//		return endrepo.save(endperson);
//	}
	public Optional<Super> findusers(Endperson endperson,int superid)
	{
		 return superRepo.findById(superid);
		
	}

	@Override
	public List<Endperson> findendusers(List<Endperson> endPerson)
	{
		return endrepo.findAll();
		// TODO Auto-generated method stub
		
	}
	public boolean validateToken(String token) {
		return token!=null && !token.isEmpty();
	}

	//@Override
//	public List<Super> findendusers(int superid) {
//		// TODO Auto-generated method stub
//		return superRepo.findAll();
//	}

	@Override
	public List<Super> getendusers(String Jwt) {
		// TODO Auto-generated method stub
		return superRepo.findAll();
	}

//	public List<Super> getSuperAdminsByUserId(int superid) {
//
//		  return superRepo.findBySuperId(superid);
//		    }
//
//	@Override
//	public List<Super> findBySuperId(int superid) {
//		// TODO Auto-generated method stub
//		return superRepo.findBySuperId(superid);
//	}

}
