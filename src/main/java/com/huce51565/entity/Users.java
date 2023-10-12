package com.huce51565.entity;

import org.springframework.stereotype.Component;

@Component
public class Users {
	private String id;
	private String fullName;
	private String dateOfBirth;
	private String email;
	private int phoneNumber;
	private String password;
	private String avatar;
	private String address;
	private String activeStatus;
	private String priority;
	
	private boolean isEmail(String input) {
	    return input.contains("@") && input.contains(".");
	}

	public Users() {
	    
	}
	
	public Users(String id, String fullName, String dateOfBirth ,String contactInfo, String password, String address) {
	    super();
	    this.id = id;
	    this.fullName = fullName;
	    this.dateOfBirth = dateOfBirth;
	    this.password = password;
	    this.address = address;

	    if (isEmail(contactInfo)) {
	        this.email = contactInfo;
	    } else {
	        try {
	            this.phoneNumber = Integer.parseInt(contactInfo);
	        } catch (NumberFormatException e) {
	            System.out.println("Không thể chuyển chỗi contactInfo sang dạng số điện thoại");
	        }
	    }
	}
 
	public Users(String id, String fullName, String dateOfBirth, String email, int phoneNumber, String password, String avatar,
			String address, String activeStatus, String priority) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.avatar = avatar;
		this.address = address;
		this.activeStatus = activeStatus;
		this.priority = priority;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
