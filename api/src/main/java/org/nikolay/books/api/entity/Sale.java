/**
 * 
 */
package org.nikolay.books.api.entity;

/**
 * @author Nikolay Dagil
 * 
 */
public interface Sale {

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
	 * @return the role
	 */
	public String getRole();

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role);

}