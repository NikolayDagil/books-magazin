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

import org.nikolay.books.api.entity.Book;

/**
 * @author Nikolay Dagil
 * 
 */
@Entity
@Table(name = "book")
public class BookEntity implements Book, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "author", nullable = true)
	private String author;

	@Column(name = "numberPage", nullable = true)
	private Integer numberPage;

	@Column(name = "imprintDate", nullable = true)
	private Date imprintDate;

	@Column(name = "price", nullable = true)
	private Integer price;

	@Column(name = "rating", nullable = true)
	private Integer rating;

	@Column(name = "discounts", nullable = true)
	private Integer discounts;

	@Column(name = "status", nullable = true)
	private Boolean status;

	/**
	 * 
	 */
	public BookEntity() {
	}

	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param numberPage
	 * @param imprintDate
	 * @param price
	 * @param rating
	 * @param discounts
	 * @param status
	 */
	public BookEntity(Long id, String title, String author, Integer numberPage,
			Date imprintDate, Integer price, Integer rating, Integer discounts,
			Boolean status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.numberPage = numberPage;
		this.imprintDate = imprintDate;
		this.price = price;
		this.rating = rating;
		this.discounts = discounts;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the numberPage
	 */
	public Integer getNumberPage() {
		return numberPage;
	}

	/**
	 * @param numberPage the numberPage to set
	 */
	public void setNumberPage(Integer numberPage) {
		this.numberPage = numberPage;
	}

	/**
	 * @return the imprintDate
	 */
	public Date getImprintDate() {
		return imprintDate;
	}

	/**
	 * @param imprintDate the imprintDate to set
	 */
	public void setImprintDate(Date imprintDate) {
		this.imprintDate = imprintDate;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the discounts
	 */
	public Integer getDiscounts() {
		return discounts;
	}

	/**
	 * @param discounts the discounts to set
	 */
	public void setDiscounts(Integer discounts) {
		this.discounts = discounts;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}