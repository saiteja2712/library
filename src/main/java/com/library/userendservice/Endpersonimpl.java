package com.library.userendservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.config.JwtProvider;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
@Service
public class Endpersonimpl implements Endpersoninterface {

	@Autowired
	private Endrepo endrepo;
	@Autowired
	private Superinterface superinter;
	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private PasswordEncoder passwordencoder;
	@Override
	public Endperson findByemail(String email) {
		// TODO Auto-generated method stub
		return endrepo.findByEmail(email);
	}

	@Override
	public Endperson findUserByJwt(String jwt) {
		// TODO Auto-generated method stub
		String email=JwtProvider.getEmailFromJwtToken(jwt);
		Endperson person=endrepo.findByEmail(email);
		return person;
	}

//	@Override
//	public List<Endperson> findallendusers(int id) {
//		// TODO Auto-generated method stub
//		superinter.findSuperuserByid(id);
//		return endrepo.findBySuperAdminId(id);
//	}

	@Override
	public Endperson findEnduserByid(int id) throws Exception {
		Optional<Endperson>endperson=endrepo.findById(id);
		if(endperson.isPresent())
		{
			return endperson.get();
		}
		// TODO Auto-generated method stub
		throw new Exception ("user not found with "+id);
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		endrepo.deleteById(id);
		
	}

	@Override
	public List<Endperson> findallenders(Super sup,String jwt) {
		// TODO Auto-generated method stub
		superinter.findUserByJwt(jwt);
		
		return endrepo.findAll();
	}

	@Override
	public List<Endperson> findallendpersons(Super sup) throws Exception {
		//superinter.findUserByJwt(jwt);
		// TODO Auto-generated method stub
		return endrepo.findBySup(sup);
	}

	@Override
	public Endperson insert(Endperson endperson) {
		// TODO Auto-generated method stub
		Endperson end=new Endperson();
		end.setFirstname(endperson.getFirstname());
		end.setLastname(endperson.getLastname());
		end.setEmail(endperson.getEmail());
		end.setPassword(passwordencoder.encode(endperson.getPassword()));
		Endperson saveduser=endrepo.save(endperson);
		return saveduser;
	}

	@Override
	public List<Endperson> findallendusers(int id) throws Exception {
		// TODO Auto-generated method stub
		return endrepo.findAll();
	}

//	public List<Endperson> endusers(String jwt){
//		
//		Super sup=superinter.findUserByJwt(jwt);
//		List<Endperson> end=endrepo.findAll();
//		return end;
//	
//	}
//	@Override
//	public List<Endperson> findallendusers(int id) {
//		return endrepo.findBySuperId(id);
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public List<Endperson> findallendusers(int id) {
//		
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public List<Endperson> getendusers(String jwt) {
//		
//		// TODO Auto-generated method stub
//		return endrepo.findAll();
//	}

}
