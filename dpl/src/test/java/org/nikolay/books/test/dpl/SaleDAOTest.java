/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.nikolay.books.api.entity.Sale;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.SaleDAO;
import org.nikolay.books.dpl.entity.SaleEntity;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class SaleDAOTest {

	private static final String TEST_A_STR = "Test A";
	private static final String TEST_B_STR = "Test B";

	private static final Boolean TEST_TRUE = true;

	SaleDAO saleDAO = new SaleDAO();

	@Test
	public void create() {

		/*
		 * Инициализация параметров
		 */
		int rowCount = 0;
		List<Sale> sales = null;

		/*
		 * Получение списка юзеров из БД
		 */

		sales = saleDAO.list();

		Assert.assertNotNull(sales);
		rowCount = sales.size();

		/*
		 * Create a new user
		 */
		Sale sale = new SaleEntity();
		sale.setCity(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);

		sale.setUser(user);

		saleDAO.save(sale);

		sales = saleDAO.list();

		Assert.assertNotNull(sale);
		Assert.assertEquals(rowCount + 1, sales.size());

	}

	@Test
	public void delete() {
		int rowCount = 0;
		List<Sale> sales = null;

		sales = saleDAO.list();

		Assert.assertNotNull(sales);
		rowCount = sales.size();

		Sale sale = new SaleEntity();
		sale.setCity(TEST_A_STR);
		saleDAO.save(sale);

		sales = saleDAO.list();
		Assert.assertNotNull(sales);
		Assert.assertEquals(rowCount + 1, sales.size());

		Long userId = sale.getId();
		saleDAO.delete(sale);
		sales = saleDAO.list();
		Assert.assertEquals(rowCount, sales.size());
		Assert.assertNull(saleDAO.getId(userId));
	}

	@Test
	public void update() {
		int rowCount = 0;
		List<Sale> sales = null;

		sales = saleDAO.list();

		Assert.assertNotNull(sales);
		rowCount = sales.size();

		Sale sale = new SaleEntity();
		sale.setCity(TEST_A_STR);

		User user = new UserEntity();
		user.setFirstName(TEST_A_STR);
		user.setLastName(TEST_A_STR);
		user.setUsername(TEST_A_STR);
		user.setEmail(TEST_A_STR);
		user.setIsActive(TEST_TRUE);
		sale.setUser(user);
		saleDAO.save(sale);

		sales = saleDAO.list();
		Assert.assertNotNull(sales);
		Assert.assertEquals(rowCount + 1, sales.size());

		Sale saleUpdate = null;
		saleUpdate = saleDAO.getId(sale.getId());
		System.out.println(sale.getId());
		saleUpdate.setCity(TEST_B_STR);

		saleDAO.update(saleUpdate);

		Sale saleFinal = saleDAO.getId(sale.getId());

		Assert.assertEquals(saleFinal.getCity(), TEST_B_STR);
	}

}