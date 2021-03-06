package com.thomas.bookster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.bookster.models.Book;
import com.thomas.bookster.models.User;
import com.thomas.bookster.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepo;
	
	public List<Book> getBooks(){
		return this.bRepo.findAll();
	}
	public Book findById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	public Book create(Book book) {
		return this.bRepo.save(book);
		
	}
	public Book update(Book book) {
		return this.bRepo.save(book);
	}
	
	public void delete(Book book) {
		this.bRepo.delete(book);
	}

	public void addReader(Book book, User user) {
		System.out.println(book);
		List<User> currReader = book.getReader();
		currReader.add(user);
		this.bRepo.save(book);
	}
	
	public void removeReader(Book book, User user) {
		List<User> currReader = book.getReader();
		currReader.remove(user);
		this.bRepo.save(book);
	}

	public BookRepository getbRepo() {
		return bRepo;
	}
	public void setbRepo(BookRepository bRepo) {
		this.bRepo = bRepo;
	}
}