package com.cafe24.bookmall.vo;

public class OrderBookVo implements BookmallVo{

	private Long no;
	private int orderPrice;
	private int quantity;

	private Long bookNo;
	private String title;
	private Long ordersNo;

	public OrderBookVo() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderBookVo(int orderPrice, int quantity, Long bookNo, Long ordersNo) {
		this.orderPrice = orderPrice;
		this.quantity = quantity;
		this.bookNo = bookNo;
		this.ordersNo = ordersNo;
	}



	public Long getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "OrderBookVo [bookNo=" + bookNo + ", title=" + title + ", quantity=" + quantity 
				+ "]";
	}

}
