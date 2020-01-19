package com.example.demo;

public class Member {
	String name;		// 이름
	String address;		// 주소 
	String idNumber;	// 주민등록번호
	String phoneNumber;	// 전화번호
//
	// 초기화할 값을 가진 생성자
	public Member(String name, String address, String idNumber, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberList() {
		return this.getAddress() + "," +  this.getIdNumber() + "," 
				+ this.getName() + "," + this.getPhoneNumber();

	}

}
