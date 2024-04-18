package com.library.userendRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.userendentity.Endperson;
@Repository
public interface Endrepo extends JpaRepository<Endperson,Integer> {
	public Endperson findByEmail(String email);
	//List<Endperson>findBySuperAdminid(int superid);
	//public List<Endperson>getAllUsersByAdminToken(String adminToken);
	//public List<Endperson>findByCreatedByEmail(String email);

}
