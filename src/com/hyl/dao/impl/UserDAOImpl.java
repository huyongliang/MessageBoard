package com.hyl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hyl.dao.UserDAO;
import com.hyl.model.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean doCreate(User user) {
		String sql = "insert into user_t" + "(name,password) " + "values(?,?)";
		PreparedStatement ps = null;

		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean doDelete(String userName) {
		throw new UnsupportedOperationException("暂不实现此功能,因为并没有提供后台管理模块");
	}

	@Override
	public User findByName(String userName) {
		String sql = "select name ,password from user_t"
				+ " where name=? limit 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
