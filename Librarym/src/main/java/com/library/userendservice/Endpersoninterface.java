package com.library.userendservice;

import java.util.List;

import com.library.userendentity.Endperson;

public interface Endpersoninterface {
	public Endperson findByemail(String email);
	public Endperson findUserByJwt(String jwt);
	public List<Endperson> findallendusers(int id);
	public Endperson findEnduserByid(int id) throws Exception;

}
