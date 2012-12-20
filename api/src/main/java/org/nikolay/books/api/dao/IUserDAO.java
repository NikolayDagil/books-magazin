/**
 * 
 */
package org.nikolay.books.api.dao;

import org.nikolay.books.api.dao.base.IBaseDAO;
import org.nikolay.books.api.entity.User;

/**
 * @author Nikolay Dagil
 * 
 */
public interface IUserDAO extends IBaseDAO<User, Long> {

	public User getAuthentication(String username, String password);

	public Boolean isExistsByUsername(String login);

	public Boolean isExistsByEmail(String email);

}