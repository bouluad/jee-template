package com.app.business.service;

import java.util.List;
import java.util.Map;

import com.app.business.bo.Book;
import com.app.business.bo.Rayon;
import com.app.business.bo.Theme;

public interface BookService {
	public void addNewBook(Book pBook);

	public List<Book> getAllBooks();

	public Map<String, Number> getBooksStat();

	public List<Book> finBookByTitle(String pTitle);

	public List<Rayon> getAllRayons();

	public List<Theme> getAllThemes();
	
	public Theme getThemeByNom(String pTheme);
	
	public Rayon getRayonByNom(String pRayon);

	public List<String> getThemeOfRayon(String rayon);

}
