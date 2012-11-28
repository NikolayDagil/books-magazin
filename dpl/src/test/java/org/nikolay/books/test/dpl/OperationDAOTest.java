/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.Book;
import org.nikolay.books.api.entity.Customer;
import org.nikolay.books.api.entity.Operation;
import org.nikolay.books.dpl.dao.OperationDAO;
import org.nikolay.books.dpl.entity.BookEntity;
import org.nikolay.books.dpl.entity.CustomerEntity;
import org.nikolay.books.dpl.entity.OperationEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class OperationDAOTest {

	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	OperationDAO operationDAO = new OperationDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<Operation> operations = null;

		operations = operationDAO.list();

		Assert.assertNotNull(operations);
		rowCount = operations.size();

		Operation operation = new OperationEntity();

		Book book = new BookEntity();
		book.setAuthor(TEST_A_STR);
		book.setTitle(TEST_B_STR);

		operation.setBook(book);
		operationDAO.save(operation);

		operations = operationDAO.list();

		Assert.assertNotNull(operations);
		Assert.assertEquals(rowCount + 1, operations.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<Operation> operations = null;

		operations = operationDAO.list();

		Assert.assertNotNull(operations);
		rowCount = operations.size();

		Operation operation = new OperationEntity();

		Book book = new BookEntity();
		book.setAuthor(TEST_A_STR);
		book.setTitle(TEST_B_STR);

		operation.setBook(book);
		operationDAO.save(operation);

		operations = operationDAO.list();
		Assert.assertNotNull(operations);
		Assert.assertEquals(rowCount + 1, operations.size());

		Long operationID = operation.getId();
		operationDAO.delete(operation);
		operations = operationDAO.list();
		Assert.assertEquals(rowCount, operations.size());
		Assert.assertNull(operationDAO.getId(operationID));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<Operation> operations = null;

		operations = operationDAO.list();

		Assert.assertNotNull(operations);
		rowCount = operations.size();

		Operation operation = new OperationEntity();

		Book book = new BookEntity();
		book.setAuthor(TEST_A_STR);
		book.setTitle(TEST_A_STR);
		operation.setBook(book);

		Customer customer = new CustomerEntity();
		customer.setAddress(TEST_A_STR);
		customer.setCity(TEST_A_STR);
		operation.setCustomer(customer);

		operationDAO.save(operation);

		operations = operationDAO.list();
		Assert.assertNotNull(operations);
		Assert.assertEquals(rowCount + 1, operations.size());

		Operation operationUpdate = null;
		operationUpdate = operationDAO.getId(operation.getId());

		Book book1 = new BookEntity();
		book1.setAuthor(TEST_B_STR);
		book1.setTitle(TEST_B_STR);

		operationUpdate.setBook(book1);
		operationDAO.update(operationUpdate);

		Operation operationFinal = operationDAO.getId(operation.getId());

		Assert.assertEquals(operationFinal.getBook().getAuthor(), TEST_B_STR);
	}

}