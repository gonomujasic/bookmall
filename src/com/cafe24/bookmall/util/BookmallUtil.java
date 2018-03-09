package com.cafe24.bookmall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class BookmallUtil {

	private final static int LIST_COUNT = 100;
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/bookmall";

			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static int getListCount() {
		return LIST_COUNT;
	}
	
	public static String getOrderingNo() {
		
		Calendar cal = Calendar.getInstance();
		StringBuilder orderingNo = new StringBuilder();
		orderingNo.append("ORDER_");
		
		synchronized (orderingNo) {
			orderingNo.append(cal.getTimeInMillis());
		}
		
		return orderingNo.toString();
		
	}
	
}
