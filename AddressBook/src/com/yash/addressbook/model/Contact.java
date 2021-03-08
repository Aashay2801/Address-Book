package com.yash.addressbook.model;

public class Contact {
	
	private int contactId;
	private int userId;
	private String contactName;
	private String phoneNo;
	private String address;
	private String email;
	private String contactGroup;
	
	public int getConactId(){
                 return contactId;
        }
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactGroup() {
		return contactGroup;
	}
	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
