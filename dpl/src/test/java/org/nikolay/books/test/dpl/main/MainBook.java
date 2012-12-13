/**
 * 
 */
package org.nikolay.books.test.dpl.main;

import org.nikolay.books.api.dao.IBookDAO;
import org.nikolay.books.api.entity.Book;
import org.nikolay.books.dpl.dao.BookDAO;
import org.nikolay.books.dpl.entity.BookEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class MainBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			Book book = new BookEntity();
			book.setAuthor("Author_" + i);
			book.setTitle("Title_" + i);

			IBookDAO bookDAO = new BookDAO();
			bookDAO.save(book);
		}

	}

}