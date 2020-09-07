package com.sp.manpwr.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTO {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String userName;
	@NotNull
	@NotEmpty
	private String passWord;

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

}
