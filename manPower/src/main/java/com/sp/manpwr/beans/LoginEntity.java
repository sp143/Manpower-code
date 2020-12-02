package com.sp.manpwr.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_M")
public class LoginEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String pass_word;
	private String user_name;
	private Long user_master_id;
	private Date lastLogin;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id", updatable = false)
	 */
	private String roleM;

	public String getRoleM() {
		return roleM;
	}

	public void setRoleM(String roleM) {
		this.roleM = roleM;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	private String record_status;

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public Long getUser_master_id() {
		return user_master_id;
	}

	public void setUser_master_id(Long user_master_id) {
		this.user_master_id = user_master_id;
	}

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

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
