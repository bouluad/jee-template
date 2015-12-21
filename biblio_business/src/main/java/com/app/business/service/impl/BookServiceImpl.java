package com.app.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.business.bo.Book;
import com.app.business.bo.Rayon;
import com.app.business.bo.Theme;
import com.app.business.dao.BookDao;
import com.app.business.dao.RayonDao;
import com.app.business.dao.ThemeDao;
import com.app.business.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	private RayonDao rayonDao;
	private ThemeDao themeDao;

	public void addNewBook(Book pBook) {
		bookDao.create(pBook);

	}

	public List<Book> getAllBooks() {
		return bookDao.getAll();
	}

	public List<Book> finBookByTitle(String pTitle) {

		return bookDao.getBookByTitle(pTitle);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Map<String, Number> getBooksStat() {
		int compteur = 0;
		List<Book> books = bookDao.getAll();
		Map<String, Number> data = new HashMap<String, Number>();
		for (Book iti : books) {
			compteur = 0;
			for (Book itj : books) {
				if (iti.getTheme().getNom().equals(itj.getTheme().getNom()))
					compteur++;
			}
			data.put(iti.getTheme().getNom(), compteur);
		}

		return data;
	}

	public List<Rayon> getAllRayons() {
		return rayonDao.getAll();
	}

	public List<Theme> getAllThemes() {
		return themeDao.getAll();
	}

	public RayonDao getRayonDao() {
		return rayonDao;
	}

	public void setRayonDao(RayonDao rayonDao) {
		this.rayonDao = rayonDao;
	}

	public ThemeDao getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}

	public List<String> getThemeOfRayon(String rayon) {

		Rayon r = bookDao.getRayonByNom(rayon);
		List<Theme> listThemes = r.getThemes();
		List<String> themeLabels = new ArrayList<String>();
		for (Theme it : listThemes) {
			themeLabels.add(it.getNom());
		}
		return themeLabels;
	}

	@Override
	public Theme getThemeByNom(String pTheme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rayon getRayonByNom(String pRayon) {
		// TODO Auto-generated method stub
		return null;
	}



}
