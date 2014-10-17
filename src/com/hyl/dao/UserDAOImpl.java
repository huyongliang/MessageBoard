package com.hyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hyl.DBUtils;
import com.hyl.model.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean doCreate(User user) {
		String sql = "insert into user_t" + "(id,name,password) "
				+ "values(null,?,?)";
		PreparedStatement ps = null;

		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(null, ps, null);
		}

		return false;
	}

	@Override
	public boolean doDelete(String userName) {
		return false;
	}

	@Override
	public User findByName(String userName) {
		String sql = "select id ,name ,password from user_t"
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
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, ps, null);
		}
		return user;
	}

}
