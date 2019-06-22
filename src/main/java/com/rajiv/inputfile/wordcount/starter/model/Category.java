/**
 * 
 */
package com.rajiv.inputfile.wordcount.starter.model;

/**
 * @author Rajiv
 *
 */
public class Category {

	String categoryKey;
	String categoryItem;
	String categorySubItem;
	String occurrence;

	/**
	 * @param categoryKey
	 * @param categoryItem
	 * @param categorySubItem
	 * @param occurrence
	 */
	public Category(String categoryKey, String categoryItem, String categorySubItem) {
		super();
		this.categoryKey = categoryKey;
		this.categoryItem = categoryItem;
		this.categorySubItem = categorySubItem;

	}

	/**
	 * @return the categoryKey
	 */
	public String getCategoryKey() {
		return categoryKey;
	}

	/**
	 * @param categoryKey the categoryKey to set
	 */
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	/**
	 * @return the categoryItem
	 */
	public String getCategoryItem() {
		return categoryItem;
	}

	/**
	 * @param categoryItem the categoryItem to set
	 */
	public void setCategoryItem(String categoryItem) {
		this.categoryItem = categoryItem;
	}

	/**
	 * @return the categorySubItem
	 */
	public String getCategorySubItem() {
		return categorySubItem;
	}

	/**
	 * @param categorySubItem the categorySubItem to set
	 */
	public void setCategorySubItem(String categorySubItem) {
		this.categorySubItem = categorySubItem;
	}

	/**
	 * @return the occurrence
	 */
	public String getOccurrence() {
		return occurrence;
	}

	/**
	 * @param occurrence the occurrence to set
	 */
	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}

}
