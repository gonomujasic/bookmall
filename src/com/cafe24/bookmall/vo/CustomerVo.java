package com.cafe24.bookmall.vo;

public class CustomerVo implements BookmallVo{

	private long no;
	private String name;
	private String phone;
	private String email;
	private String password;

	public CustomerVo() {
	}
	
	public CustomerVo(String name, String phone, String email, String password) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + "]";
	}
}
