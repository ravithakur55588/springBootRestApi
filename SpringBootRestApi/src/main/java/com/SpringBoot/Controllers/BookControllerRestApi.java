package com.SpringBoot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Entity.Book;
import com.SpringBoot.Services.BookService;

/*@Controller use for normal work but when we use the rest api we should use @RestController
  @RestController don't need @ResponseBody annotation. 

@Controller    
public class BookControllerRestApi {

	@RequestMapping(value="/book", method = RequestMethod.GET)
	@ResponseBody
	public String book() {
		return "This is book controller";
	}
}

*/
/*
@RestController    
public class BookControllerRestApi {

	@GetMapping("/book")
	public Book book() {
		
		Book b1 = new Book();
		b1.setBid(101);
		b1.setBname("Apj");
		b1.setBauthor("Author");
		
		return b1;
	}
*/


@RestController    
public class BookControllerRestApi {
	
	@Autowired
	private BookService bookservice;

	//to show all books using get api
	@GetMapping("/book")
	public List<Book> book() {
		return this.bookservice.getAllBooks();
	}

	//get book by id
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookservice.getBookById(id);
	}
	
	//adding book using post api
	@PostMapping("/book")
	public Book addBook(@RequestBody  Book bk) {
		Book b = this.bookservice.addBook(bk);
		return b;
	}
	
	//deleteing book using delete api
	@DeleteMapping("/book/{bid}")
	public void deleteBook(@PathVariable("bid") int bookId) {
		this.bookservice.deleteBook(bookId);
	}
	
	//updating data using put api
	@PutMapping("/book/{bid}")
	public Book updateBook(@RequestBody Book bk,@PathVariable("bid") int id ) {
		this.bookservice.updateBook(bk,id);
		return bk;
	}
}
