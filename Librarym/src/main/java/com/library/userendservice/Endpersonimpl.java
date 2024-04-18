package com.library.userendservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.config.JwtProvider;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
@Service
public class Endpersonimpl implements Endpersoninterface {

	@Autowired
	private Endrepo endrepo;
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

	@Override
	public List<Endperson> findallendusers(int id) {
		// TODO Auto-generated method stub
		return endrepo.findAll();
	}

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

}
