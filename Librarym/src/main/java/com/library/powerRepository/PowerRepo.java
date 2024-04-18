package com.library.powerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Power;

@Repository
public interface PowerRepo extends JpaRepository<Power,Integer> {
	public Power findByEmail(String email);

}
