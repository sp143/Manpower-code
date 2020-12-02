package com.sp.manpwr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.manpwr.beans.LoginEntity;
import com.sp.manpwr.dto.UserCredential;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginService loginService;

	@Autowired
	UserCredential userCredential;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		System.out.println("ssoId::" + ssoId);
		LoginEntity login = loginService.findUserByLoginName(ssoId);
		boolean credentialValid;

		userCredential.setEmail(login.getEmail());
		userCredential.setPassWord(login.getPass_word());

		if (login.getRecord_status().equals("INACTIVE")) {
			credentialValid = false;
		} else {
			credentialValid = true;
		}
		return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getPass_word(),
				login.getRecord_status().equals("ACTIVE"), credentialValid, credentialValid, credentialValid,
				getGrantedAuthorities(login));
	}

	private List<GrantedAuthority> getGrantedAuthorities(LoginEntity login) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + login.getRoleM().trim()));
		System.out.print("authorities :" + authorities);
		return authorities;
	}
}