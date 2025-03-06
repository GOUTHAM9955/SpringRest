package com.launch.jacksonapi;

public class StudentModel {
	
	int id;
	String sName;
	String sEmail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	
	
	public StudentModel(int id, String sName, String sEmail) {
		super();
		this.id = id;
		this.sName = sName;
		this.sEmail = sEmail;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", sName=" + sName + ", sEmail=" + sEmail + "]";
	}
	
	

}
