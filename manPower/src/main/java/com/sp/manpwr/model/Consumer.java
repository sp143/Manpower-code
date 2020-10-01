package com.sp.manpwr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSUMER_M")
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fName;
	private String lName;
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	@Column(name = "phNo", length = 13)
	private String phNo;
	@Column(name = "Address", length = 50)
	private String address;
	@Column(name = "adhaar_id", length = 16)
	private String adhaarid;
	private Date DOB;
	@Column(name = "Gender", length = 2)
	private String Gender;
	private String profession;
	@Column(name = "RECORD_STATUS")
	private String record_status;
	private Date create_date;

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	private Date update_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

}
