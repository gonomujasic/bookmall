package com.cafe24.bookmall.util;

import java.util.HashMap;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.BookmallDao;
import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.dao.CustomerDao;
import com.cafe24.bookmall.dao.OrderBookDao;
import com.cafe24.bookmall.dao.OrdersDao;

public class DaoFactory {

	private static class Singleton {
		static HashMap<String, BookmallDao> map = new HashMap<>();
	}
	
	public HashMap<String, BookmallDao> getDaoMap() {
		
		if(Singleton.map.isEmpty())
			makeDao();
		
		return Singleton.map;
	}

	private void makeDao() {
		
		HashMap<String, BookmallDao> map = Singleton.map;
			
		map.put("CustomerDao", new CustomerDao());
		map.put("CategoryDao", new CategoryDao());
		map.put("BookDao", new BookDao());
		map.put("CartDao", new CartDao());
		map.put("OrdersDao", new OrdersDao());
		map.put("OrderBookDao", new OrderBookDao());
		
	}
	
	public BookmallDao getDao(String dao) {
		
		if(Singleton.map.isEmpty())
			makeDao();
		
		return getDaoMap().get(dao);
	}
	
}
