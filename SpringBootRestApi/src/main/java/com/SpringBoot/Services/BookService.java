package com.SpringBoot.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.SpringBoot.Entity.Book;

@Component
public class BookService {

	//creating fake services.
	private static List<Book> list = new ArrayList<Book>();
	
	static {
		list.add(new Book(101,"java reference","xyz"));
		list.add(new Book(102,"cpp reference","abc"));
		list.add(new Book(103,"c reference","LMN"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book b2 = null;
		//use for each or below method
		b2 = list.stream().filter(e->e.getBid()==id).findFirst().get();
		return b2;
	}
	
	//adding the book
	public Book addBook(Book b) {
		list.add(b);  
		return b;
	}
	
	//delete book
/*	public void deleteBook(int bid) {
		list.stream().filter(book ->{
			if(book.getBid() != bid) {
				return true;
			}else {
				return false;
			}
			
		}).collect(Collectors.toList());
	}
*/	
	public void deleteBook(int bid) {
		list = list.stream().filter(book -> book.getBid() != bid).collect(Collectors.toList());
	}
	
	//updating data using id
	public void updateBook(Book book, int bookid) {
		list = list.stream().map(b ->{
			if(b.getBid()==bookid) {
				b.setBauthor(book.getBauthor());
				b.setBname(book.getBname());
			}return b;
		}).collect(Collectors.toList());
	}
}
