/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.IOperationDAO;
import org.nikolay.books.api.entity.Operation;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.OperationEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class OperationDAO extends BaseDAO<Operation, OperationEntity, Long>
		implements IOperationDAO {

	public OperationDAO() {
		super(OperationEntity.class);
	}

}