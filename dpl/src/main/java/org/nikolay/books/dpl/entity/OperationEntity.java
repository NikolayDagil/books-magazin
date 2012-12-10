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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nikolay.books.api.entity.Book;
import org.nikolay.books.api.entity.Customer;
import org.nikolay.books.api.entity.Operation;

/**
 * @author Nikolay Dagil
 * 
 */
@Entity
@Table(name = "transaction")
public class OperationEntity implements Operation, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(targetEntity = CustomerEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk")
	private Customer customer;

	@ManyToOne(targetEntity = BookEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_fk")
	private Book book;

	/**
	 * 
	 */
	public OperationEntity() {
	}

	/**
	 * @param id
	 * @param book
	 * @param customer
	 */
	public OperationEntity(Long id, Book book, Customer customer) {
		this.id = id;
		this.book = book;
		this.customer = customer;
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

}