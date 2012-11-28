/**
 * 
 */
package org.nikolay.books.api.entity;

import java.util.Date;

/**
 * @author Nikolay Dagil
 * 
 */
public interface User {

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
	 * @return the firstName
	 */
	public String getFirstName();

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName);

	/**
	 * @return the lastName
	 */
	public String getLastName();

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName);

	/**
	 * @return the username
	 */
	public String getUsername();

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username);

	/**
	 * @return the email
	 */
	public String getEmail();

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email);

	/**
	 * @return the mobile
	 */
	public Long getMobile();

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(Long mobile);

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive();

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive);

	/**
	 * @return the password
	 */
	public Long getPassword();

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(Long password);

	/**
	 * @return the createDate
	 */
	public Date getCreateDate();

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate);

}