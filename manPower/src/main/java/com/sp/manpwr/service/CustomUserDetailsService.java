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

import com.sp.manpwr.beans.UserDetail;
import com.sp.manpwr.dto.UserCredential;

@Service
public class CustomUserDetailsService implements UserDetailsService{
 
    @Autowired
    private UserService userService;
    
    @Autowired
    UserCredential userCredential;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {    	
    	System.out.println("ssoId::" +ssoId);
        UserDetail user = userService.findUserByLoginName(ssoId);
        boolean credentialValid;
		
		  userCredential.setEmail(user.getEmail());
		  userCredential.setPassWord(user.getPassWord());
		 
        if (user.getStatus().equals("INACTIVE")) {
			credentialValid = false;
		} else {
			credentialValid = true;
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassWord(),
				user.getStatus().equals("ACTIVE"), credentialValid, credentialValid, credentialValid,
				getGrantedAuthorities(user));
   }

    
   private List<GrantedAuthority> getGrantedAuthorities(UserDetail user){
       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getUserRole()));
       System.out.print("authorities :"+authorities);
       return authorities;
   }
}