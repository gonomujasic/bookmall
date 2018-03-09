package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookmallDao;
import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.util.DaoFactory;
import com.cafe24.bookmall.vo.BookmallVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class Test {
	
	static DaoFactory dfc = new DaoFactory();
	
	public static void main(String[] args) {

		
		//BookmallDao bd = dfc.getDao("CustomerDao");
		//BookmallDao bd = dfc.getDao("CategoryDao");
		//BookmallDao bd = dfc.getDao("BookDao");
		//BookmallDao bd = dfc.getDao("CartDao");
		BookmallDao bd = dfc.getDao("OrdersDao");
		//BookmallDao bd = dfc.getDao("OrderBookDao");
		
		insert(bd);
		getList(bd);
		
	}
	
	public static void insert(BookmallDao bd) {
		
		//고객정보 삽입
//		CustomerVo vo = 
//				new CustomerVo("아무개", "010-1111-2222",
//						"amuge@hotmail.com", "1234");
//		CustomerVo vo = 
//				new CustomerVo("이민규", "010-5559-9634",
//						"gonomujasic@hotmail.com", "1234");		
		
		//카테고리정보 삽입
//		CategoryVo vo = new CategoryVo();
//		vo.setCategory("문학");
//		vo.setCategory("자연과학");
//		vo.setCategory("사회과학");

		//서적정보 삽입
//		BookVo vo = new BookVo("사회학개론",30000, 3);
//		BookVo vo = new BookVo("컴퓨터개론",30000, 2);
//		BookVo vo = new BookVo("경제학개론",30000, 3);
	
		//카트정보 삽입
//		CartVo vo = new CartVo(2L,1L,1);
//		CartVo vo = new CartVo(1L,1L,1);
		
		//주문정보 삽입
//		OrdersVo vo = new OrdersVo(BookmallUtil.getOrderingNo(), 
//				"서울시 구로구", 30000, 1L);
//		OrdersVo vo = new OrdersVo(BookmallUtil.getOrderingNo(), 
//				"서울시 광진구", 30000, 2L);
		OrdersVo vo = new OrdersVo(BookmallUtil.getOrderingNo(), 
				"서울시 금천구", 30000, 1L);
		
		//주문서적정보 삽입
//		OrderBookVo vo = new OrderBookVo(30000, 1, 1L, 1L);
//		OrderBookVo vo = new OrderBookVo(30000, 2, 2L, 2L);
		
		bd.insert(vo);
		
	}
	
	public static void getList(BookmallDao bd) {
		
		List<BookmallVo> list = bd.getList(1);
		
		for(BookmallVo vo : list) {
			System.out.println(vo.toString());
		}
	}

}
