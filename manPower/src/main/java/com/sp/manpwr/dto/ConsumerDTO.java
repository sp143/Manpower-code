package com.sp.manpwr.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ConsumerDTO {
	@NotNull
	@NotEmpty
	private String fName;
	@NotNull
	@NotEmpty
	private String lName;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String phNo;
	private String address;
	private String adhaarid;
	private Date DOB;
	private Date Gender;
	private String profession;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdhaarid() {
		return adhaarid;
	}
	public void setAdhaarid(String adhaarid) {
		this.adhaarid = adhaarid;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Date getGender() {
		return Gender;
	}
	public void setGender(Date gender) {
		Gender = gender;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

}
