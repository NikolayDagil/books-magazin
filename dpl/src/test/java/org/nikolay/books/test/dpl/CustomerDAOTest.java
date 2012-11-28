/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.Customer;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.CustomerDAO;
import org.nikolay.books.dpl.entity.CustomerEntity;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class CustomerDAOTest {
	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	private static final Boolean TEST_TRUE = true;

	CustomerDAO customerDAO = new CustomerDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<Customer> customers = null;

		/*
		 * Получение списка юзеров из БД
		 */

		customers = customerDAO.list();

		Assert.assertNotNull(customers);
		rowCount = customers.size();

		/*
		 * Create a new user
		 */
		Customer customer = new CustomerEntity();
		customer.setCity(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);

		customer.setUser(user);

		customerDAO.save(customer);

		customers = customerDAO.list();

		Assert.assertNotNull(customer);
		Assert.assertEquals(rowCount + 1, customers.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<Customer> customers = null;

		customers = customerDAO.list();

		Assert.assertNotNull(customers);
		rowCount = customers.size();

		Customer customer = new CustomerEntity();
		customer.setCity(TEST_A_STR);
		customerDAO.save(customer);

		customers = customerDAO.list();
		Assert.assertNotNull(customers);
		Assert.assertEquals(rowCount + 1, customers.size());

		Long customerId = customer.getId();
		customerDAO.delete(customer);
		customers = customerDAO.list();
		Assert.assertEquals(rowCount, customers.size());
		Assert.assertNull(customerDAO.getId(customerId));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<Customer> customers = null;

		customers = customerDAO.list();

		Assert.assertNotNull(customers);
		rowCount = customers.size();

		Customer customer = new CustomerEntity();
		customer.setCity(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		customer.setUser(user);
		customerDAO.save(customer);

		customers = customerDAO.list();
		Assert.assertNotNull(customers);
		Assert.assertEquals(rowCount + 1, customers.size());

		Customer customerUpdate = null;
		customerUpdate = customerDAO.getId(customer.getId());
		customerUpdate.setCity(TEST_B_STR);

		customerDAO.update(customerUpdate);

		Customer customerFinal = customerDAO.getId(customer.getId());

		Assert.assertEquals(customerFinal.getCity(), TEST_B_STR);
	}

}