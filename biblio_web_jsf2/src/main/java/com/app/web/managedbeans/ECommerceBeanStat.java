package com.app.web.managedbeans;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.PieChartModel;

import com.app.business.service.BookService;

public class ECommerceBeanStat extends BaseManagedBean {
	private PieChartModel pieModel;

	private BookService bookService;

	public ECommerceBeanStat() {

	}

	@PostConstruct
	public void createPieModel() {
		pieModel = new PieChartModel();
		System.out.println(bookService);
		pieModel.setData(bookService.getBooksStat());

	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
