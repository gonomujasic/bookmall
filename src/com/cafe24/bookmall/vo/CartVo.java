package com.cafe24.bookmall.vo;

public class CartVo implements BookmallVo {

	private Long bookNo;
	private Long customerNo;
	private int quantity;

	private String title;
	private int price;

	public CartVo() {
	}
	
	public CartVo(Long bookNo, Long customerNo, int quantity) {
		super();
		this.bookNo = bookNo;
		this.customerNo = customerNo;
		this.quantity = quantity;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", customerNo=" + customerNo + ", quantity=" + quantity + ", title=" + title
				+ ", price=" + price + "]";
	}

}
