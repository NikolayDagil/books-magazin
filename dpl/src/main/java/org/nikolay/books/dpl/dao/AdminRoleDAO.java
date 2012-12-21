/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.IAdminRoleDAO;
import org.nikolay.books.api.entity.AdminRole;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.AdminRoleEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class AdminRoleDAO extends BaseDAO<AdminRole, AdminRoleEntity, Long>
		implements IAdminRoleDAO {

	public AdminRoleDAO() {
		super(AdminRoleEntity.class);
	}

}