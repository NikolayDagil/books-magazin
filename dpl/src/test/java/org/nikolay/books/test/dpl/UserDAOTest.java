/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class UserDAOTest {

	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	private static final Boolean TEST_TRUE = true;
	private static final Boolean TEST_FALSE = false;

	UserDAO userDAO = new UserDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<User> users = null;

		/*
		 * Получение списка юзеров из БД
		 */

		users = userDAO.list();

		Assert.assertNotNull(users);
		rowCount = users.size();

		/*
		 * Create a new user
		 */
		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		userDAO.save(user);

		users = userDAO.list();

		Assert.assertNotNull(users);
		Assert.assertEquals(rowCount + 1, users.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<User> users = null;

		users = userDAO.list();

		Assert.assertNotNull(users);
		rowCount = users.size();

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		userDAO.save(user);

		users = userDAO.list();
		Assert.assertNotNull(users);
		Assert.assertEquals(rowCount + 1, users.size());

		Long userId = user.getId();
		userDAO.delete(user);
		users = userDAO.list();
		Assert.assertEquals(rowCount, users.size());
		Assert.assertNull(userDAO.getId(userId));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<User> users = null;

		users = userDAO.list();

		Assert.assertNotNull(users);
		rowCount = users.size();

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		userDAO.save(user);

		users = userDAO.list();
		Assert.assertNotNull(users);
		Assert.assertEquals(rowCount + 1, users.size());

		User userUpdate = null;
		userUpdate = userDAO.getId(user.getId());

		userUpdate.setFirstName(TEST_B_STR);
		userUpdate.setLastName(TEST_B_STR);
		userUpdate.setUsername(TEST_B_STR);
		userUpdate.setEmail(TEST_B_STR);
		userUpdate.setIsActive(TEST_FALSE);

		userDAO.update(userUpdate);

		User userFinal = userDAO.getId(user.getId());

		Assert.assertEquals(userFinal.getFirstName(), TEST_B_STR);
	}

}