package com.cafe24.bookmall.vo;

public class BookVo implements BookmallVo {

	private Long no;
	private String title;
	private int price;

	private int categoryNo;
	private String category;

	public BookVo() {
		// TODO Auto-generated constructor stub
	}
	
	public BookVo(String title, int price, int categoryNo) {
		this.title = title;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", categoryNo=" + categoryNo
				+ ", category=" + category + "]";
	}

}
