package com.hyl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/MessageBoard?useUnicode=true&characterEncoding=utf8",
							"root", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void release(ResultSet rs, Statement ps, Connection conn) {
		release(rs);
		release(ps);
		release(conn);
	}

	public static void release(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(ResultSet rs, PreparedStatement ps) {
		release(rs);
		release(ps);
	}

	private static void release(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Statement ps) {
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
