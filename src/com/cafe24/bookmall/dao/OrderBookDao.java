package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class OrderBookDao implements BookmallDao<OrderBookVo> {

	@Override
	public boolean insert(OrderBookVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = BookmallUtil.getConnection();
			String sql = "INSERT INTO ORDER_BOOK "
					+ "(NO, ORDER_PRICE, QUANTITY, ORDERS_NO, BOOK_NO) "
					+ "VALUES(NULL, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getOrderPrice());
			pstmt.setInt(2, vo.getQuantity());
			pstmt.setLong(3, vo.getOrdersNo());
			pstmt.setLong(4, vo.getBookNo());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrderBookVo> getList(int page) {
		List<OrderBookVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BookmallUtil.getConnection();

			String sql = "SELECT B.NO, B.TITLE, OB.QUANTITY "
					+ "FROM BOOK B, ORDER_BOOK OB, ORDERS O "
					+ "WHERE B.NO = OB.BOOK_NO "
					+ "AND O.NO = OB.ORDERS_NO "
					+ "ORDER BY O.NO " + "LIMIT ?, ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (page - 1) * BookmallUtil.getListCount());
			pstmt.setInt(2, BookmallUtil.getListCount());

			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {

				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setQuantity(rs.getInt(3));

				list.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("sql 에러" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

}
