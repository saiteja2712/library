package com.library.superRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.superentity.Super;
import com.library.userendentity.Endperson;

@Repository
public interface SuperRepo extends JpaRepository<Super,Integer> {
	
	public Super findByEmail(String email);
	//public List<Super>findById(int id);
	//public Super findById(int superid);
	//public List<Endperson>findByCreatedByEmail(String email); 

//	@Query("select s.super_id,e.user_id,e.firstname,e.lastname,e.email From super s JOIN endperson e ON s.super_id=e.super_id ")
//	public List<Super> findBySuperId(int superid);

}
