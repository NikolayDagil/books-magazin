/**
 * 
 */
package org.nikolay.books.api.entity;

/**
 * @author Nikolay Dagil
 * 
 */
public interface Operation {

	/**
	 * @return the id
	 */
	public Long getId();

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id);

	/**
	 * @return the book
	 */
	public Book getBook();

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book book);

	/**
	 * @return the customer
	 */
	public Customer getCustomer();

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer);

}