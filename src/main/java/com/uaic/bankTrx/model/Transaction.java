package com.uaic.bankTrx.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private User fromUser;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private User toUser;

	private Double amount;

	public Transaction() {
	}

	public Transaction(User fromUser, User toUser, Double amount) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
	}

}
