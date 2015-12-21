package com.ensah.dao;

import java.io.Serializable;
import java.util.List;

import com.boudaa.dao.GenericDao;
import com.ensah.bo.Book;

public interface BookDao extends GenericDao<Book, Long> {

	public List<Book> getBookByTitle(String title);
	public List<Book> getBookByIsbn(String isbn);
}
