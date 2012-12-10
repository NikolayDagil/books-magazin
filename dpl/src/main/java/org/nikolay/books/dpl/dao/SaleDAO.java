/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.ISaleDAO;
import org.nikolay.books.api.entity.Sale;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.SaleEntity;

/**
 * @author Nikolay Dagil
 * @version 1.0
 */
public class SaleDAO extends BaseDAO<Sale, SaleEntity, Long> implements
		ISaleDAO {

	public SaleDAO() {
		super(SaleEntity.class);
	}

}