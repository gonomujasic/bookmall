package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class OrdersDao implements BookmallDao<OrdersVo> {

	@Override
	public boolean insert(OrdersVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = BookmallUtil.getConnection();
			String sql = "INSERT INTO ORDERS "
					+ "(NO, ORDERING_NO, ADDRESS, SUM, CUSTOMER_NO) "
					+ "VALUES(NULL, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrdering_no());
			pstmt.setString(2, vo.getAddress());
			pstmt.setInt(3, vo.getSum());
			pstmt.setLong(4, vo.getCustomerNo());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrdersVo> getList(int page) {
		List<OrdersVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BookmallUtil.getConnection();

			String sql = "SELECT O.NO, O.ORDERING_NO, O.ADDRESS, O.SUM, C.NO, C.NAME, C.EMAIL "
					+ "FROM ORDERS O, CUSTOMER C "
					+ "WHERE O.CUSTOMER_NO = C.NO "
					+ "ORDER BY O.NO " + "LIMIT ?, ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (page - 1) * BookmallUtil.getListCount());
			pstmt.setInt(2, BookmallUtil.getListCount());

			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {

				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setOrdering_no(rs.getString(2));
				vo.setAddress(rs.getString(3));
				vo.setSum(rs.getInt(4));
				vo.setCustomerNo(rs.getLong(5));
				vo.setName(rs.getString(6));
				vo.setEmail(rs.getString(7));

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
