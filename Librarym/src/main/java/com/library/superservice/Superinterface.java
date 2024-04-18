package com.library.superservice;

import java.util.List;
import java.util.Optional;

import com.library.superentity.Super;
import com.library.userendentity.Endperson;

public interface Superinterface {
	public Super findByEmail(String email);
	public Super findUserByJwt(String jwt);
	public List<Super>getendusers(String Jwt);
	//public Super Createenduser(Endperson endperson,String email);
	//public List<Super>findendusers(int superid);
	public List<Endperson> findendusers(List<Endperson> endPerson);
	public Optional<Super> findById(int superid) throws Exception;
	//public Super Createenduser(Super sup,int id);
	 public Super Createenduser(Endperson endperson, int superid);
	// public Optional<List<Super>> findallendpersons(int superid);

	//public Optional<Endperson> Createenduser(String firstname,String lastname,String email,String password,int superId);
	//public Endperson Createendperson(Endperson endperson);
//	!!!
	//public List<Endperson>getAllUsersByAdminToken(String adminToken);
	
	
}
