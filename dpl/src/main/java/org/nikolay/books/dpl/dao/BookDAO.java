/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.IBookDAO;
import org.nikolay.books.api.entity.Book;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.BookEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0
 */
public class BookDAO extends BaseDAO<Book, BookEntity, Long> implements
		IBookDAO {

	public BookDAO() {
		super(BookEntity.class);
	}

}