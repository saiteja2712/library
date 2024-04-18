package com.library.PowerService;

import java.util.List;

import com.library.entity.Power;
import com.library.superentity.Super;
import com.library.userendentity.Endperson;

public interface Powerinterface {
	public Power findByEmail(String email);
	public Power findUserByJwt(String jwt);
	public Super Createsuperuser(Super sup);
	public Endperson Createenduser(Endperson endperson,int id);
	//public List<Endperson> findallendusers(Endperson endperson,int id) throws Exception;
	public List<Endperson> findallendusers(Endperson endperson);

}
