package com.library.userendservice;

import java.util.List;

import com.library.entity.Power;
import com.library.superentity.Super;
import com.library.userendentity.Endperson;

public interface Endpersoninterface {
	public Endperson insert(Endperson endperson);
	public Endperson findByemail(String email);
	public Endperson findUserByJwt(String jwt);
	public List<Endperson> findallendpersons(Super sup) throws Exception;
	public Endperson findEnduserByid(int id) throws Exception;
	public void deletebyid(int id);
	//public List<Endperson>getendusers(String jwt);
	//public List<Endperson> findallendusers(int id);
	public List<Endperson> findallendusers(int id) throws Exception;
	public List<Endperson> findallenders(Super sup,String jwt) throws Exception;

}
