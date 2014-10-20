package com.hyl.service.impl;

import java.sql.Connection;

import com.hyl.DBUtils;
import com.hyl.dao.impl.UserDAOImpl;
import com.hyl.model.User;
import com.hyl.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	
	@Override
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
			DBUtils.release( conn);
		}
		return false;
	}
}
