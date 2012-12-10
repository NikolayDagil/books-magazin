/**
 * 
 */
package org.nikolay.books.test.dpl;

import java.util.Date;

import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.UserDAO;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Stas Sarosek
 * @version 1.0.1
 */
public class MainUser {

	private static final String USERNAME = "stas_sarosek";
	private static final String PASSWORD = "Qwerty123";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		User user = new UserEntity();
		user.setFirstName("Stas");
		user.setLastName("Sarosek");
		user.setEmail("sarosek.stas@gmail.com");
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setIsActive(true);
		user.setCreateDate(new Date());

		IUserDAO userDAO = new UserDAO();
		userDAO.save(user);
		
		userDAO.getAuthentication(USERNAME, PASSWORD);

	}

}