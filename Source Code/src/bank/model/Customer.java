package bank.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Customer implements Serializable{
	private String uid;
	private String name;
	private String emailid;
	private String password;
	private String dob;
	private String phno;
	private String address;
	private String gender;
	private String pinno;
	public Customer(String uid, String name, String emailid, String password,
			String dob, String phno, String address, String gender, String pinno) {
		super();
		this.uid = uid;
		this.name = name;
		this.emailid = emailid;
		this.password = password;
		this.dob = dob;
		this.phno = phno;
		this.address = address;
		this.gender = gender;
		this.pinno = pinno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPinno() {
		return pinno;
	}
	public void setPinno(String pinno) {
		this.pinno = pinno;
	}
	
}
