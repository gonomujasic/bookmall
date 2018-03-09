package com.cafe24.bookmall.vo;

public class OrdersVo implements BookmallVo {

	private Long no;
	private String ordering_no;
	private int sum;
	private String address;

	private Long customerNo;
	private String name;
	private String email;

	public OrdersVo() {
	}

	public OrdersVo(String ordering_no, String address, int sum, Long customerNo) {
		this.ordering_no = ordering_no;
		this.address = address;
		this.sum = sum;
		this.customerNo = customerNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrdering_no() {
		return ordering_no;
	}

	public void setOrdering_no(String ordering_no) {
		this.ordering_no = ordering_no;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Long cstmNo) {
		this.customerNo = cstmNo;
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

	@Override
	public String toString() {
		return "OrdersVo [ordering_no=" + ordering_no + ", sum=" + sum 
				+ ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
}
