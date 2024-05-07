package com.library.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.library.book.Book;
import com.library.book.service.Bookinterface;
import com.library.bookcategory.Category;
import com.library.bookcategoryrepo.CategoryRepo;
import com.library.bookrepo.BookRepo;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;

@RestController
@RequestMapping("/auth/book")
public class Authbookcontroller {
	@Autowired 
	private Bookinterface bookinter;
	@Autowired
	private BookRepo bookrepo;
	@Autowired 
	private Superinterface superinter;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private Endpersoninterface endinter;
	@Autowired
	private Endrepo endrepo;
//	@PostMapping("/insert")
//	public Book insert(@RequestBody Book book) {
//		return bookinter.insert(book);
//		
//	}
	@GetMapping("/bookget")
	public List<Book>findAll()
	{
		return bookinter.findall();
		
	}
//	@GetMapping("/browse/{id}")
//	public ResponseEntity<List<Book>>getbycategory(@PathVariable int id)
//	{
//		List<Book>books=bookrepo.findAllByCategoryEquals(id);
//		System.out.println(books);
//		return ResponseEntity.ok(books);
//	}
//	@PostMapping("/addbook")
//    public ResponseEntity<Book> addBook(@RequestParam("title") String title,
//                                        @RequestParam("author") String author,
//                                        @RequestParam("publishedYear") int publishedYear,
//                                        @RequestParam("imageUrl") String imageUrl,
//                                        @RequestParam("categoryId") Long categoryId) {
//        try {
//            Book savedBook = bookinter.addBook(title, author, author, imageUrl, publishedYear);
//            return ResponseEntity.ok(savedBook);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}
	
	@PostMapping("/upload/{cname}")
		public Book uploadImage(@RequestParam("imageofbook")MultipartFile imageofbook, @RequestParam("titleofbook")String titleofbook,@RequestParam("author")String author,@RequestParam("publishyear")String publishyear,@RequestHeader("Authorization")String jwt,@PathVariable String cname) throws  Exception 
	{
		Super sup=superinter.findUserByJwt(jwt);
		String var=sup.getToken();
		if(jwt.substring(7).equals(var))
		{
			Book i=new Book();
			i.setImageofbook((imageofbook.getBytes()));
			i.setTitleofbook(titleofbook);
			i.setAuthor(author);
			i.setPublishyear(publishyear);
			Category category=categoryRepo.findByName(cname);
			i.setCategory(category);
			
//			Map<String,String>m=new HashMap<>();
//			m.put("File Name",imageofbook.getBytes());
//			m.put("titleofbook",titleofbook );
//			m.put("author", author);
//			m.put("publishyear", publishyear);
			return bookrepo.save(i);
		}else {
			throw new Exception("not found");
			
		}
	}
	@GetMapping("/{name}")
	public List<Book>findbycategoryname(@PathVariable String name,@RequestBody Book book)
	{
		Category cat=categoryRepo.findByName(name);
		return bookrepo.findAll();
	}
	@GetMapping("/books/{categoryName}")
    public List<Book> getBooksByCategory(@PathVariable String categoryName) {
        // Assuming you have a method in BookRepository to find books by category
        return bookrepo.findByCategoryName(categoryName);
	}
	private byte[] compress(byte[] bytes) {
	// TODO Auto-generated method stub
	return null;
}
//	@PostMapping("/assign/{endpersonId}/{bookId}")
//    public String assignBook(@PathVariable int endpersonId, @PathVariable int bookId) {
//        bookinter.assignBook(endpersonId, bookId);
//        return "assigned successfully";
//    }
	@PostMapping("/bookemail/{email}/{bookId}")
	public String assignemail(@PathVariable String email,@PathVariable int bookId,@RequestHeader("Authorization")String jwt)
	{
		Endperson endp=endinter.findUserByJwt(jwt);
		String var=endp.getToken();
		if(jwt.substring(7).equals(var))
		{
		bookinter.bookemailassign(email, bookId);
		return "assigned through email";
		}
		else {
			return "failed";
		}
	}
//	@PostMapping("/assignbook/{bookId}")
//	public String assign(@RequestHeader("Authorization")String jwt,@PathVariable int bookId)
//	{
//		Endperson user=endinter.findUserByJwt(jwt);
//		String var=user.getToken();
//		if(jwt.substring(7).equals(var))
//		{
//			 Book book = bookrepo.findById(bookId)
//		                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
//			if (book.getAssignedTo() != null) {
//	            throw new IllegalStateException("Book is already assigned to a user");
//			}
//			bookinter.assignBook(bookId);
//	            user.getAssignedBooks().add(book);
//			    book.setAssignedTo(null);
//			    endrepo.save(user);
//	        
//			return "book assigned to user succcessfully";
//		}
//		
//		else {
//			return "book asigned failed";
//		}
//	}
	
//	@PostMapping("/assign")
//    public String assignBook(@RequestHeader("Authorization")String jwt, @RequestParam int bookId) {
//		Endperson end=endinter.findUserByJwt(jwt);
//		String var=end.getToken();
//		if(jwt.substring(7).equals(var))
//		{
//			bookinter.assignBook(bookId);
//		}
//        bookinter.assignBook(bookId);
//        return "assigned successfully";
//    }
	@PostMapping("/release/{endpersonId}/{bookId}")
	public String releaseBook(@PathVariable int endpersonId, @PathVariable int bookId) {
	    
		
		bookinter.releaseBook(endpersonId, bookId);
	    return "released successfully";
	}
	@PostMapping("/releasedemail/{email}/{bookId}")
	public String releaseemail(@PathVariable String email,@PathVariable int bookId,@RequestHeader("Authorization")String jwt)
	{
		Endperson endp=endinter.findUserByJwt(jwt);
		String var=endp.getToken();
		if(jwt.substring(7).equals(var))
		{
		bookinter.releaseBooks(email, bookId);
		return "released successfully";
	}
		else {
			return "failed";
		}
	}
	@GetMapping("/assigned")
    public Iterable<Book> getAllAssignedBooks() {
        return bookinter.getAllAssignedBooks();
    }
//	@GetMapping("/assigned/{endpersonId}")
//    public Iterable<Book> getAssignedBooksForUser(@PathVariable int endpersonId) {
//        return bookinter.getAssignedBooksForUser(endpersonId);
//    }
	@GetMapping("/assigned/{email}")
    public Iterable<Book> getAssignedBooksForUser(@PathVariable String email,@RequestHeader("Authorization")String jwt) throws Exception {
		Endperson end=endinter.findUserByJwt(jwt);
		String var=end.getToken();
		System.out.println(var);
		if(jwt.substring(7).equals(var))
		{
        return bookinter.getAssignedBooksForUser(email);
    }
		else {
			 throw new Exception ("invalid token");
		}
		
}
}
//	
//	


