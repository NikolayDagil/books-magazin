/**
 * 
 */
package org.nikolay.books.dpl.dao;

import org.nikolay.books.api.dao.ICustomerDAO;
import org.nikolay.books.api.entity.Customer;
import org.nikolay.books.dpl.dao.base.BaseDAO;
import org.nikolay.books.dpl.entity.CustomerEntity;

/**
 * @author Nikolay Dagil
 * 
 */
public class CustomerDAO extends BaseDAO<Customer, CustomerEntity, Long>
		implements ICustomerDAO {

	public CustomerDAO() {
		super(CustomerEntity.class);
	}

}