package com.sakondri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sakondri.model.baseentity.BaseEntity;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity{
	@Column(name = "FIRST_NAME" ,nullable = false)
	private String fName;
	@Column(name = "LAST_NAME" , nullable = false)
	private String lName;
	@Column(name = "GENDER" ,nullable = false)
	private String gender;
	
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
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
