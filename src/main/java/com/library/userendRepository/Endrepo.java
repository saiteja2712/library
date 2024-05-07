package com.library.userendRepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.library.superentity.Super;
import com.library.userendentity.Endperson;
import com.library.superentity.Super;

@Repository
public interface Endrepo extends JpaRepository<Endperson,Integer> {
	public Endperson findByEmail(String email);
	List<Endperson> findBySup(Super sup);
	//public List<Super>endperson(String jwt);
	//public List<Endperson>getAllUsersByAdminToken(String adminToken);
	//public List<Endperson>findByCreatedByEmail(String email);

}
