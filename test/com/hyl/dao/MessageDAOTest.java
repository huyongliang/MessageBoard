package com.hyl.dao;

import java.sql.Connection;
import java.util.Date;

import org.junit.Test;

import com.hyl.DBUtils;
import com.hyl.dao.impl.MessageDAOImpl;
import com.hyl.model.Message;

public class MessageDAOTest {
	private Connection conn = null;

	{
		conn = DBUtils.getConnection();
	}

	@Test
	public void testDoCreate() {
		Message m=new Message(0, 1, "ss", "ssss", new Date());
		System.out.println(new MessageDAOImpl(conn).doCreate(m));
	}

	@Test
	public void testDoList() {
		System.out.println(new MessageDAOImpl(conn).doList());
	}

}
