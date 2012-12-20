/**
 * 
 */
package org.nikolay.books.dpl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nikolay.books.api.entity.User;

/**
 * @author Nikolay Dagil
 * 
 */
@Entity
@Table(name = "user")
public class UserEntity implements User, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "mobile", nullable = true)
	private String mobile;

	@Column(name = "isActive", nullable = false)
	private Boolean isActive;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "createDate", nullable = true)
	private Date createDate;

	/**
	 * 
	 */
	public UserEntity() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param email
	 * @param mobile
	 * @param isActive
	 * @param password
	 * @param createDate
	 */
	public UserEntity(Long id, String firstName, String lastName,
			String username, String email, String mobile, Boolean isActive,
			String password, Date createDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.isActive = isActive;
		this.password = password;
		this.createDate = createDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserEntity [" + (id != null ? "id=" + id + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (mobile != null ? "mobile=" + mobile + ", " : "")
				+ (isActive != null ? "isActive=" + isActive + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (createDate != null ? "createDate=" + createDate : "") + "]";
	}

}