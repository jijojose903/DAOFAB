package com.jijo.assignment.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Jijo Jose
 *
 */
@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Parent parent;
	private Integer paidAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}
}
