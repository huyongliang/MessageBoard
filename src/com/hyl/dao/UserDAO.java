package com.hyl.dao;

import com.hyl.model.User;

public interface UserDAO {
	boolean doCreate(User user);

	boolean doDelete(String userName);

	public User findByName(String userName);
}
