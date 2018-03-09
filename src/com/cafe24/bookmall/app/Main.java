package com.cafe24.bookmall.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cafe24.bookmall.dao.BookmallDao;
import com.cafe24.bookmall.util.DaoFactory;
import com.cafe24.bookmall.vo.BookmallVo;

public class Main {

	public static void main(String[] args) {
		
		showList();
		
	}
	
	public static void showList() {
		
		DaoFactory dfc = new DaoFactory();
		HashMap<String, BookmallDao> map = dfc.getDaoMap();
		
		Iterator iter = map.values().iterator();
		
		while(iter.hasNext()) {
			
			BookmallDao dao = (BookmallDao) iter.next();
			List<BookmallVo> list = dao.getList(1);
			
			for(BookmallVo vo : list) {
				System.out.println(vo.toString());
			}
			System.out.println("======================================================================================================");
			
		}
		
	}

}
