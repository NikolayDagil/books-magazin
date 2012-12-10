/**
 * 
 */
package org.nikolay.books.test.dpl;

import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.UserDAO;

/**
 * @author Nikolay Dagil
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserDAO userDAO = new UserDAO();
		
		User user =userDAO.getUserByUsername("admin");
		
		System.out.println(user.getPassword());
		
		
	}

}
