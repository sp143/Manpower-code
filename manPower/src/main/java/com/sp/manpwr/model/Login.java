package com.sp.manpwr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login_M")
public class Login {
	@Id
	private Long id;
	private String email;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false, unique = true)
	private String passWord;
	private String userMasterId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}
}
