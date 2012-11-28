/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.IAdminDAO;
import org.nikolay.books.api.entity.Admin;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.AdminEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class AdminDAO extends BaseDAO<Admin, AdminEntity, Long> implements
		IAdminDAO {

	public AdminDAO() {
		super(AdminEntity.class);
	}

}