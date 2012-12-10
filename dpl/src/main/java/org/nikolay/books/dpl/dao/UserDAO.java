/**
 * 
 */
package org.nikolay.books.dpl.dao;

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
 * 
 */
public class UserDAO extends BaseDAO<User, UserEntity, Long> implements
		IUserDAO {

	public UserDAO() {
		super(UserEntity.class);
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new UserEntity();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Query query = session
					.createQuery("from UserEntity u where u.username = :username");
			query.setParameter("username", username);
			user = (User) query.list().get(0);

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