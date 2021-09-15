package com.jijo.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Jijo Jose
 *
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sender;
	private String receiver;
	private Integer totalAmount;
	@Formula("(select sum(cd.paid_amount) from child cd where cd.parent_id= id)")
	public Integer amountPaid;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Child> childList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getAmountPaid() {
		return amountPaid == null ? 0 : amountPaid;
	}

	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}
}
