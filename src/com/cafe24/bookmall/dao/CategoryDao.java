package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.BookmallUtil;
import com.cafe24.bookmall.vo.CategoryVo;
import com.cafe24.bookmall.vo.CustomerVo;

public class CategoryDao implements BookmallDao<CategoryVo> {

	@Override
	public boolean insert(CategoryVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = BookmallUtil.getConnection();
			String sql = "INSERT INTO CATEGORY VALUES(NULL, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getCategory());

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CategoryVo> getList(int page) {
		List<CategoryVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BookmallUtil.getConnection();

			String sql = "SELECT NO, CATEGORY "
					+ "FROM CATEGORY " 
					+ "LIMIT ?, ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (page - 1) * BookmallUtil.getListCount());
			pstmt.setInt(2, BookmallUtil.getListCount());

			rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {

				CategoryVo vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setCategory(rs.getString(2));

				list.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("sql 에러" + e);
			e.printStackTrace();
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
