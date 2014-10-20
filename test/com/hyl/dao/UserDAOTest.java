package com.hyl.dao;

import java.sql.Connection;

import org.junit.Test;

import com.hyl.DBUtils;
import com.hyl.dao.impl.UserDAOImpl;
import com.hyl.model.User;

public class UserDAOTest {

	private Connection conn = null;

	{
		conn = DBUtils.getConnection();
	}

	@Test
	public void testDoCreate() {
		System.out.println(new UserDAOImpl(conn).doCreate(new User("test1",
				"123")));
	}

	@Test
	public void testFindByName() {
		System.out.println(new UserDAOImpl(conn).findByName("test1"));
	}

}
