package com.library.superservice;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.library.book.Book;
import com.library.superentity.Super;
import com.library.userendentity.Endperson;

public interface Superinterface {
	public List<Super> getall();
	
	//public Super findSuperuserByid(int id);
	public Super findByEmail(String email);
	public Super findUserByJwt(String jwt);
	//nextline
//	public List<Super>findbyJwt(String jwt);
	public Optional<Super> findById(int superid) throws Exception;
	//public Super Createenduser(Super sup,int id);
	 public Endperson Createenduser(Endperson endperson, int superid);
	 public Super Createbook(Book book,int superid);
	 public void addbook(String title,String author,String publisher,MultipartFile image);
	// public Optional<List<Super>> findallendpersons(int superid);
	List<Super> findendusers(int superid);
	Super findSuperuserByid(int id) throws Exception;

	
	
}
