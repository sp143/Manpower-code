package com.sp.manpwr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABOUR_M")
public class Labour_m {
	@Id
	@Column
	private Long userId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	@Column(name = "phNo", length = 13)
	private String phNo;
	@Column
	private String sex;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String skill_id;
	private String address1;
	private String address2;
	@Column(name = "adhaar_id", length = 16)
	private String adhaarid;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAdhaarid() {
		return adhaarid;
	}

	public void setAdhaarid(String adhaarid) {
		this.adhaarid = adhaarid;
	}
}
