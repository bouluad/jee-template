package com.ensah.services;

import java.util.List;

import com.ensah.bo.Book;
import com.ensah.dao.BookDao;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	public void addNewBook(Book pBook) {
		bookDao.create(pBook);
	}

	public void update(Book book)
	{
		bookDao.update(book);
		
		
	}
	
	public void delet(Book book)
	{
		bookDao.delete(book.getId());
		
		
	}
	
	public List<Book> getAllBooks() {
		return bookDao.getAll();
	}

	public List<Book> finBookByTitle(String pTitle) {
		return bookDao.getBookByTitle(pTitle);
	}
	
	public List<Book> finBookByIsbn(String isbn) {
		return bookDao.getBookByIsbn(isbn);
	}
	
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}