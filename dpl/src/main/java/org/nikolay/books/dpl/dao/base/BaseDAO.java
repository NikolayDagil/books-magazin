/**
 * 
 */
package org.nikolay.books.dpl.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nikolay.books.dpl.dao.util.HibernateUtil;

/**
 * @author Nikolay Dagil
 * @version 1.0
 */
public abstract class BaseDAO<I, T extends I, PK extends Serializable> {

	private Class<T> entityClass;

	/**
	 * @param entityClass
	 */
	public BaseDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/*
	 * Создание нового объекта
	 */
	public void save(I newInstance) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(newInstance);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Исправление объекта
	 */
	public void update(I transientObject) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(transientObject);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 
	 * @param persistentObject
	 */
	/*
	 * Удаление объекта
	 */
	public void delete(I persistentObject) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(persistentObject);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Получение id номера объекта
	 */

	public I getId(Long PK) {
		I i = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			i = (I) session.get(entityClass, PK);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return i;
	}

	/*
	 * Получение списка объектов
	 */
	public List<I> list() {
		List<I> list = new ArrayList<I>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			list = session.createQuery("FROM " + entityClass.getName()).list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
}