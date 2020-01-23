package com.uaic.bankTrx.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Double amount;

	// create a new table with id's
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="USER_USER_LOGIN_INFO", joinColumns = @JoinColumn(name="USER_ID"),
			inverseJoinColumns = @JoinColumn(name="USER_LOGIN_INFO_ID"))

	//@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private UserLoginInfo userLoginInfo;

	public User() {
	}

	public User(String name, Double amount) {
		this.name = name;
		this.amount = amount;
	}

	public User(String name, Double amount, UserLoginInfo userLoginInfo) {
		this.name = name;
		this.amount = amount;
		this.userLoginInfo = userLoginInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public UserLoginInfo getUserLoginInfo() {
		return userLoginInfo;
	}

	public void setUserLoginInfo(UserLoginInfo userLoginInfo) {
		this.userLoginInfo = userLoginInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
