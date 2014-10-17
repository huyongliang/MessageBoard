package com.hyl.service;

import java.sql.Connection;

import com.hyl.DBUtils;
import com.hyl.dao.UserDAOImpl;
import com.hyl.model.User;

public class LoginService {
	public boolean loginValidate(String userName, String password) {
		Connection conn = DBUtils.getConnection();
		try {
			User user = new UserDAOImpl(conn).findByName(userName);
			if (user == null)
				return false;
			if (user.getPassword().equals(password))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtils.release(null, null, conn);
		}
		return false;
	}
}
