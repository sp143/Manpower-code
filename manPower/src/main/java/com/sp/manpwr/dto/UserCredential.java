package com.sp.manpwr.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
public class UserCredential {
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String passWord;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
