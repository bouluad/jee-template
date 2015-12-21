package com.app.business.dao.impl;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.app.business.bo.Book;
import com.app.business.bo.Rayon;
import com.app.business.dao.BookDao;
import com.boudaa.dao.impl.GenericDaoImpl;

public class BookDaoImpl extends GenericDaoImpl<Book, Long> implements BookDao {

	public BookDaoImpl() {
		super(Book.class);
	}

	public List<Book> getBookByTitle(String pTitle) {

		return getHibernateTemplate().find("from Book where title=?", pTitle);

	}

	public Rayon getRayonByNom(String rayon) {

		List l = getHibernateTemplate().find("from Rayon where nom=?", rayon);

		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(Rayon.class, rayon);

		return (Rayon) l.get(0);

	}

}
