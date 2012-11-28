/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class UserDAO extends BaseDAO<User, UserEntity, Long> implements
		IUserDAO {

	public UserDAO() {
		super(UserEntity.class);
	}

}