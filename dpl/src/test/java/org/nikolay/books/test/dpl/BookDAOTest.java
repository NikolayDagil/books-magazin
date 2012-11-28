/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.Book;
import org.nikolay.books.dpl.dao.BookDAO;
import org.nikolay.books.dpl.entity.BookEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class BookDAOTest {

	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	BookDAO bookDAO = new BookDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<Book> books = null;

		/*
		 * Получение списка юзеров из БД
		 */

		books = bookDAO.list();

		Assert.assertNotNull(books);
		rowCount = books.size();

		/*
		 * Create a new user
		 */
		Book book = new BookEntity();
		book.setAuthor(TEST_A_STR);

		bookDAO.save(book);

		books = bookDAO.list();

		Assert.assertNotNull(books);
		Assert.assertEquals(rowCount + 1, books.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<Book> books = null;

		books = bookDAO.list();

		Assert.assertNotNull(books);
		rowCount = books.size();

		Book book = new BookEntity();
		book.setAuthor(TEST_A_STR);
		bookDAO.save(book);

		books = bookDAO.list();
		Assert.assertNotNull(books);
		Assert.assertEquals(rowCount + 1, books.size());

		Long bookId = book.getId();
		bookDAO.delete(book);
		books = bookDAO.list();
		Assert.assertEquals(rowCount, books.size());
		Assert.assertNull(bookDAO.getId(bookId));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<Book> books = null;

		books = bookDAO.list();

		Assert.assertNotNull(books);
		rowCount = books.size();

		Book book = new BookEntity();

		book.setAuthor(TEST_A_STR);

		bookDAO.save(book);

		books = bookDAO.list();
		Assert.assertNotNull(books);
		Assert.assertEquals(rowCount + 1, books.size());

		Book bookUpdate = null;
		bookUpdate = bookDAO.getId(book.getId());
		bookUpdate.setAuthor(TEST_B_STR);

		bookDAO.update(bookUpdate);

		Book bookFinal = bookDAO.getId(book.getId());

		Assert.assertEquals(bookFinal.getAuthor(), TEST_B_STR);
	}

}