package com.datanauts.rest.model;

public class User {

    public User() {

    }

	public User(Integer userId, String name, String email, String address, String phone, String accountNo) {
        super();
        this.userId = userId;
        this.name = name;
        this.email = email;
        
        this.address = address;
        this.phone = phone;
        this.accountNo = accountNo;
    }
 
    private Integer userId;
    private String name;
    private String email;
    
    private String address;
    private String phone;
    private String accountNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", accountNo=" + accountNo + "]";
	}
	
    
}
