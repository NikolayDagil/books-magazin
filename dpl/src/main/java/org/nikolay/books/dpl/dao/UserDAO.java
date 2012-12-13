/**
 * 
 */
package org.nikolay.books.dpl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nikolay.books.api.dao.IUserDAO;
import org.nikolay.books.api.entity.User;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.dao.util.HibernateUtil;
import org.nikolay.books.dpl.entity.UserEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0
 */
public class UserDAO extends BaseDAO<User, UserEntity, Long> implements
		IUserDAO {

	public UserDAO() {
		super(UserEntity.class);
	}

	@Override
	public User getAuthentication(String username, String password) {
		User user = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Query query = session
					.createQuery("from UserEntity user where user.username = :username and user.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);

			List<User> users = new ArrayList<>();
			users = query.list();

			if (!users.isEmpty()) {
				user = users.get(0);
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

}