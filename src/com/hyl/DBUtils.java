package com.hyl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static String driverClassName = null;
	private static String jdbcUrl = null;
	private static String user = null;
	private static String password = null;

	static {
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream(
				"db.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			driverClassName = properties.getProperty("driverClass");
			jdbcUrl = properties.getProperty("jdbcUrl");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		// 读取类路径下的配置文件

		try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
