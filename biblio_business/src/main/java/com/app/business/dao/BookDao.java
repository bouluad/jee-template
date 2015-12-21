package com.app.business.dao;

import java.util.List;

import com.app.business.bo.Book;
import com.app.business.bo.Rayon;
import com.boudaa.dao.GenericDao;

public interface BookDao extends GenericDao<Book, Long> {

	public List<Book> getBookByTitle(String pTitle);

	public Rayon getRayonByNom(String rayon);
}
