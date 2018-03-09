package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;

public class CartDao implements BookmallDao<CartVo> {

	@Override
	public boolean insert(CartVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = BookmallUtil.getConnection();
			String sql = "INSERT INTO CART VALUES(?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getCustomerNo());
			pstmt.setInt(3, vo.getQuantity());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CartVo> getList(int page) {
		List<CartVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BookmallUtil.getConnection();

			String sql = "SELECT CSTMR.NO, B.NO, B.TITLE, C.QUANTITY, B.PRICE "
					+ "FROM CART C, BOOK B, CUSTOMER CSTMR "
					+ "WHERE C.BOOK_NO = B.NO "
					+ "AND C.CUSTOMER_NO = CSTMR.NO "
					+ "ORDER BY B.NO " + "LIMIT ?, ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (page - 1) * BookmallUtil.getListCount());
			pstmt.setInt(2, BookmallUtil.getListCount());

			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {

				CartVo vo = new CartVo();
				vo.setBookNo(rs.getLong(1));
				vo.setCustomerNo(rs.getLong(2));
				vo.setTitle(rs.getString(3));
				vo.setQuantity(rs.getInt(4));
				vo.setPrice(rs.getInt(5));

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
