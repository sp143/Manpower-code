package com.sp.manpwr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.manpwr.beans.LoginEntity;
import com.sp.manpwr.beans.UserDetail;
import com.sp.manpwr.dao.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public void updateLoginDetails(LoginEntity user) {
		loginRepository.save(user);
	}

	public LoginEntity findUserByLoginName(String user_name) {
		LoginEntity loginEntity = loginRepository.findUserByLoginName(user_name);
		return loginEntity;
	}
	
	public LoginEntity findUserByLoginNameSS(String email) {
		LoginEntity loginEntity = loginRepository.findUserByEmailSS(email).get();
		return loginEntity;
	}
}
