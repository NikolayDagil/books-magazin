/**
 * 
 */
package org.nikolay.books.api.entity;

import java.util.Date;

/**
 * @author Nikolay Dagil
 * 
 */
public interface Book {

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
	 * @return the title
	 */
	public String getTitle();

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title);

	/**
	 * @return the author
	 */
	public String getAuthor();

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author);

	/**
	 * @return the numberPage
	 */
	public Integer getNumberPage();

	/**
	 * @param numberPage
	 *            the numberPage to set
	 */
	public void setNumberPage(Integer numberPage);

	/**
	 * @return the imprintDate
	 */
	public Date getImprintDate();

	/**
	 * @param imprintDate
	 *            the imprintDate to set
	 */
	public void setImprintDate(Date imprintDate);

	/**
	 * @return the price
	 */
	public Integer getPrice();

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price);

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
	 * @return the discounts
	 */
	public Integer getDiscounts();

	/**
	 * @param discounts
	 *            the discounts to set
	 */
	public void setDiscounts(Integer discounts);

	/**
	 * @return the status
	 */
	public Boolean getStatus();

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Boolean status);

}