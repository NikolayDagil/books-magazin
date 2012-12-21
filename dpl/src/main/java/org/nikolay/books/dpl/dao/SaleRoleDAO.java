/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.ISaleRoleDAO;
import org.nikolay.books.api.entity.SaleRole;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.SaleRoleEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class SaleRoleDAO extends BaseDAO<SaleRole, SaleRoleEntity, Long>
		implements ISaleRoleDAO {

	public SaleRoleDAO() {
		super(SaleRoleEntity.class);
	}

}