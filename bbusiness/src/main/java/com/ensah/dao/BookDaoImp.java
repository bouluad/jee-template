package com.ensah.dao;

import java.util.List;

import com.boudaa.dao.impl.GenericDaoImpl;
import com.ensah.bo.Book;

public class BookDaoImp extends GenericDaoImpl<Book, Long> implements BookDao {
	public BookDaoImp() {
		super(Book.class);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return getHibernateTemplate().find(
				"from Book where soundex(title)=soundex(?)", title);
	}
	
	
	public List<Book> getBookByIsbn(String isbn)
	
	{
		
		return getHibernateTemplate().find(
				"from Book where soundex(isbn)=soundex(?)", isbn);
		
	}

}
