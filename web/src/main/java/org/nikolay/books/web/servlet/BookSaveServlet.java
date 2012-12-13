/**
 * 
 */
package org.nikolay.books.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nikolay.books.api.dao.IBookDAO;
import org.nikolay.books.api.entity.Book;
import org.nikolay.books.dpl.dao.BookDAO;
import org.nikolay.books.dpl.entity.BookEntity;

/**
 * @author Nikolay Dagil
 * 
 */
@WebServlet(name = "bookSave", urlPatterns = { "/bookSave" })
public class BookSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS_PAGE = "success.jsp";
	private static final String BOOK_SAVE_PAGE = "bookSave.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(BOOK_SAVE_PAGE);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String numberPage = request.getParameter("numberPage");
		String imprintDate = request.getParameter("imprintDate");
		String price = request.getParameter("price");
		String rating = request.getParameter("rating");
		String discounts = request.getParameter("discounts");
		String status = request.getParameter("status");

		if (!author.isEmpty() && !title.isEmpty()) {

			IBookDAO bookDAO = new BookDAO();
			Book book = new BookEntity();
			book.setAuthor(author);

			if (discounts != "") {
				book.setDiscounts(Integer.parseInt(discounts));
			}
			if (price != "") {
				book.setPrice(Integer.parseInt(price));
			}
			if (rating != "") {
				book.setRating(Integer.parseInt(rating));
			}
			if (status != "") {
				book.setStatus(Boolean.valueOf(status));
			}
			if (numberPage != "") {
				book.setNumberPage(Integer.parseInt(numberPage));
			}
			if (imprintDate != "") {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				try {
					book.setImprintDate(dateFormat.parse(imprintDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			bookDAO.save(book);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(SUCCESS_PAGE);
			requestDispatcher.forward(request, response);

		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(BOOK_SAVE_PAGE);
			requestDispatcher.forward(request, response);
		}
	}
}