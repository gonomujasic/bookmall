package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CustomerVo;

public class BookDao implements BookmallDao<BookVo> {

	@Override
	public boolean insert(BookVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = BookmallUtil.getConnection();
			String sql = "INSERT INTO BOOK VALUES(NULL, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCategoryNo());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BookVo> getList(int page) {
		List<BookVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BookmallUtil.getConnection();

			String sql = "SELECT B.NO, B.TITLE, B.PRICE, C.CATEGORY "
					+ "FROM BOOK B, CATEGORY C "
					+ "WHERE B.CATEGORY_NO = C.NO "
					+ "ORDER BY B.NO " + "LIMIT ?, ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (page - 1) * BookmallUtil.getListCount());
			pstmt.setInt(2, BookmallUtil.getListCount());

			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {

				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCategory(rs.getString(4));

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
