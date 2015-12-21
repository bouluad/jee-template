package com.app.web.managedbeans;

import java.util.*;

import javax.annotation.PostConstruct;

import com.app.business.bo.Book;
import com.app.business.bo.Rayon;
import com.app.business.bo.Theme;
import com.app.business.service.BookService;

public class BookController extends BaseManagedBean {

	private Book book = new Book();

	private String rayon;

	private String theme;

	private List<Book> bookList = new ArrayList<Book>();
	private BookService bookService;

	private List<String> rayons = new ArrayList<String>();

	private List<String> themes = new ArrayList<String>();

	public BookController() {
	}

	@PostConstruct
	public void populate() {
		bookList = bookService.getAllBooks();
		List<Rayon> listRayon = bookService.getAllRayons();

		for (Rayon it : listRayon) {
			rayons.add(it.getNom());
		}

		List<Theme> listTheme = bookService.getAllThemes();
		for (Theme it : listTheme) {
			themes.add(it.getNom());
		}

	}

	public void handleRayonChange() {
		if (rayon != null && !rayon.equals(""))
			themes = populateTheme(rayon);
		else
			themes = new ArrayList<>();
	}

	private List<String> populateTheme(String rayon) {

		return bookService.getThemeOfRayon(rayon);
	}

	public String doNew() {
		return adminPage("newBook");
	}

	public String doCreateBook() {

		book.setTheme(bookService.getThemeByNom(theme));
		
		bookService.addNewBook(book);

		bookList = bookService.getAllBooks();

		return adminPage("listBooks");

	}

	public List<String> getRayons() {
		return rayons;
	}

	public void setRayons(List<String> rayons) {
		this.rayons = rayons;
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {

		this.bookList = bookList;

	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getRayon() {
		return rayon;
	}

	public void setRayon(String rayon) {
		this.rayon = rayon;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

}
