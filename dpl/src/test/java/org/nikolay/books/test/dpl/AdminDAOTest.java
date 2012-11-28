/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.Admin;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.AdminDAO;
import org.nikolay.books.dpl.entity.AdminEntity;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class AdminDAOTest {
	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	private static final Boolean TEST_TRUE = true;

	AdminDAO adminDAO = new AdminDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<Admin> admins = null;

		/*
		 * Получение списка юзеров из БД
		 */

		admins = adminDAO.list();

		Assert.assertNotNull(admins);
		rowCount = admins.size();

		/*
		 * Create a new user
		 */
		Admin admin = new AdminEntity();
		admin.setRole(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);

		admin.setUser(user);

		adminDAO.save(admin);

		admins = adminDAO.list();

		Assert.assertNotNull(admins);
		Assert.assertEquals(rowCount + 1, admins.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<Admin> admins = null;

		admins = adminDAO.list();

		Assert.assertNotNull(admins);
		rowCount = admins.size();

		Admin admin = new AdminEntity();
		admin.setRole(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);

		admin.setUser(user);

		adminDAO.save(admin);

		admins = adminDAO.list();
		Assert.assertNotNull(admins);
		Assert.assertEquals(rowCount + 1, admins.size());

		Long adminId = admin.getId();
		adminDAO.delete(admin);
		admins = adminDAO.list();
		Assert.assertEquals(rowCount, admins.size());
		Assert.assertNull(adminDAO.getId(adminId));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<Admin> admins = null;

		admins = adminDAO.list();

		Assert.assertNotNull(admins);
		rowCount = admins.size();

		Admin admin = new AdminEntity();
		admin.setRole(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		admin.setUser(user);

		adminDAO.save(admin);

		admins = adminDAO.list();
		Assert.assertNotNull(admins);
		Assert.assertEquals(rowCount + 1, admins.size());

		Admin adminUpdate = null;
		adminUpdate = adminDAO.getId(admin.getId());
		adminUpdate.setRole(TEST_B_STR);

		adminDAO.update(adminUpdate);

		Admin adminFinal = adminDAO.getId(admin.getId());

		Assert.assertEquals(adminFinal.getRole(), TEST_B_STR);
	}

}