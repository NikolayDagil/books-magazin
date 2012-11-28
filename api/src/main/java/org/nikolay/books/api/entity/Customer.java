/**
 * 
 */
package org.nikolay.books.api.entity;

import java.util.List;

/**
 * @author Nikolay Dagil
 * 
 */
public interface Customer {

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
	 * @return the user
	 */
	public User getUser();

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user);

	/**
	 * @return the address
	 */
	public String getAddress();

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address);

	/**
	 * @return the country
	 */
	public String getCountry();

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country);

	/**
	 * @return the city
	 */
	public String getCity();

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city);

	/**
	 * @return the postcode
	 */
	public Integer getPostcode();

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(Integer postcode);

	/**
	 * @return the rating
	 */
	public Integer getRating();

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Integer rating);

	/**
	 * @return the balance
	 */
	public Integer getBalance();

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(Integer balance);

	/**
	 * @return the discounts
	 */
	public Integer getDiscounts();

	/**
	 * @param discounts
	 *            the discounts to set
	 */
	public void setDiscounts(Integer discounts);

	/**
	 * @return the operations
	 */
	public List<Operation> getOperations();

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(List<Operation> operations);

}