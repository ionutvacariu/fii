package com.uaic.bankTrx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserLoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
/*
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User userDetails;*/

	private String userName;
	private String password;
	private String role;

	public UserLoginInfo() {
	}

	public UserLoginInfo(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

}
