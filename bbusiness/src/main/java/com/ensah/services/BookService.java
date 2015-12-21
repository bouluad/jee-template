package com.ensah.services;

import java.util.List;

import com.ensah.bo.Book;

public interface BookService {
	
	public void addNewBook(Book pBook);
	public void update(Book book);
	public void delet(Book book);
	public List<Book> getAllBooks();

	public List<Book> finBookByTitle(String pTitle);
	public List<Book> finBookByIsbn(String pIsbn);
}
