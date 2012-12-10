/**
 * 
 */
package org.nikolay.books.dpl.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.nikolay.books.api.entity.Admin;
import org.nikolay.books.api.entity.User;

/**
 * @author Nikolay Dagil
 * @version 1.0
 */
@Entity
@Table(name = "admin")
public class AdminEntity implements Admin, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
	private User user;

	@Column(name = "role", nullable = true)
	private String role;

	/**
	 * 
	 */
	public AdminEntity() {
	}

	/**
	 * @param id
	 * @param user
	 * @param role
	 */
	public AdminEntity(Long id, User user, String role) {
		this.id = id;
		this.user = user;
		this.role = role;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}