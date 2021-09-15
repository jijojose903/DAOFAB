/**
 * 
 */
package com.jijo.assignment.dto;

import java.util.List;

import com.jijo.assignment.model.Parent;

/**
 * Class to generate pagable response for Parent response
 * 
 * isFirst indicate that it is first page
 * 
 * isLast indicate that it is last page
 * 
 * data stands for the parent detail list
 * 
 * totalItems indicate the total available items in the system
 * 
 * pages indicates the total pages for pagination
 * 
 * pagination start from page 0
 * 
 * currentPage indicate the current standing page
 * 
 * @author Jijo Jose
 *
 */
public class ParentResponse {
	private List<Parent> data;
	private long totalItems;
	private int pages;
	private int currentPage;
	private boolean isFirst;
	private boolean isLast;

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Parent> getData() {
		return data;
	}

	public void setData(List<Parent> data) {
		this.data = data;
	}

	public boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean getIsLast() {
		return isLast;
	}

	public void seIstLast(boolean isLast) {
		this.isLast = isLast;
	}
}
