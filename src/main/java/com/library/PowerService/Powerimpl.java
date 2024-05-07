package com.library.PowerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.config.JwtProvider;
import com.library.entity.Power;
import com.library.powerRepository.PowerRepo;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;
@Service
public class Powerimpl implements Powerinterface{
	@Autowired
	private PowerRepo powerRepo;
	@Autowired
	private SuperRepo superRepo;
	@Autowired
	private Superinterface superinter;
	@Autowired
	private Endrepo endrepo;
	@Autowired
	private Endpersoninterface endinter;

	@Override
	public Power findByEmail(String email) {
		// TODO Auto-generated method stub
		return powerRepo.findByEmail(email);
	}
	

	@Override
	public Power findUserByJwt(String jwt) {
		// TODO Auto-generated method stub
		String email=JwtProvider.getEmailFromJwtToken(jwt);
		Power pow=powerRepo.findByEmail(email);
		return pow;
	}

	@Override
	public Super Createsuperuser(Super sup) {
		// TODO Auto-generated method stub
		
		return superRepo.save(sup);
	}

	@Override
	public Endperson Createenduser(Endperson endperson, int id) {
		// TODO Auto-generated method stub
	
		return endrepo.save(endperson);
	}


	@Override
	public List<Endperson> findallendusers(Endperson endperson) {
		// TODO Auto-generated method stub
		return endrepo.findAll();
	}
	public List<Super>findallsuperadmins(Super sup){
		return superRepo.findAll();
		
	}


	//->
//	@Override
//	public boolean isFirstTimeLogin(String email) {
//		// TODO Auto-generated method stub
//		Optional<Power>opt=powerRepo.findByUsername(email);
//		if(opt.isPresent())
//		{
//			Power pow=opt.get();
//			return pow;
//		}
//	}


//	@Override
//	public List<Endperson> findallendusers(Endperson endperson ,int id) throws Exception {
//		endinter.findEnduserByid(id);
//		// TODO Auto-generated method stub
//		return endrepo.findByEnduserId(id);
//	}


	
	
	
	

}
