package com.codingdojo.bookclub.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository BookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.BookRepo =  bookRepo;
	}
	
	
	// ****** find all ********
	public List<Book> allBooks(){
		return BookRepo.findAll();
	}
	
	// ****** CREATE ********
	public Book addBook(Book book) {
		// if the created Book has no id, MySql will create a new instance
		return BookRepo.save(book);
	}
	
	// ****** SHOW ONE *******
	public Book findOneBook(Long id) {
		Optional<Book> optionalBook = BookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	// ****** EDIT ********
	public Book editBook(Book book) {
		// if the created Book has no id, MySql will create a new instance
		return BookRepo.save(book);
	}
	
	// ****** DELETE ********
	public void deleteBook(Long id) {
		BookRepo.deleteById(id);
	}



	
}