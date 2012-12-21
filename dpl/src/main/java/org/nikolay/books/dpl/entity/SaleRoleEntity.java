/**
 * 
 */
package org.nikolay.books.dpl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nikolay.books.api.entity.SaleRole;

/**
 * @author Nikolay Dagil
 * 
 */
@Entity
@Table(name = "sale_role")
public class SaleRoleEntity implements SaleRole, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "role", nullable = true)
	private String role;

	/**
	 * 
	 */
	public SaleRoleEntity() {
	}

	/**
	 * @param id
	 * @param role
	 */
	public SaleRoleEntity(Long id, String role) {
		this.id = id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaleRoleEntity ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (role != null ? "role=" + role + ", " : "")
				+ (getId() != null ? "getId()=" + getId() + ", " : "")
				+ (getRole() != null ? "getRole()=" + getRole() + ", " : "")
				+ (getClass() != null ? "getClass()=" + getClass() + ", " : "")
				+ "hashCode()="
				+ hashCode()
				+ ", "
				+ (super.toString() != null ? "toString()=" + super.toString()
						: "") + "]";
	}

}