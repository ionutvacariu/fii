package com.uaic.bankTrx.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	//think have to be table (java)name _id
	//@JoinColumn(name = "from_user_id",referencedColumnName = "id",nullable = false,insertable = false, updatable = false)

	@JoinTable(name = "USER_FROM_TRANSACTIONS", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "TRANSACTION_FROM_USER"))
	private User fromUser;

	@ManyToOne
	@JoinTable(name = "USER_TO_TRANSACTIONS", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "TRANSACTION_TO_USER"))
	private User toUser;

	private Double amount;

	public Transaction() {
	}

	public Transaction(User fromUser, User toUser, Double amount) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
