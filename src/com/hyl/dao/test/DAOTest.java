package com.hyl.dao.test;

import java.sql.Connection;
import java.util.Date;

import org.junit.Test;

import com.hyl.DBUtils;
import com.hyl.dao.CatagoryDAOImpl;
import com.hyl.dao.MessageDAOImpl;
import com.hyl.dao.UserDAOImpl;
import com.hyl.model.Catagory;
import com.hyl.model.Message;
import com.hyl.model.User;
import com.hyl.service.LoginService;

public class DAOTest {
	private Connection conn = null;

	{
		conn = DBUtils.getConnection();
	}

	@Test
	public void testLIstMsg() {
		System.out.println(new MessageDAOImpl(conn).doList());
	}

	@Test
	public void testAddMsg() {
		Message message = new Message(0, 1, "s", "ddd", "ssss", new Date());
		System.out.println(new MessageDAOImpl(conn).doCreate(message));
	}

	@Test
	public void testGetUser() {
		System.out.println(new UserDAOImpl(conn).findByName("aa"));
	}

	@Test
	public void testAddUser() {
		System.out.println(new UserDAOImpl(conn)
				.doCreate(new User("sss", "sss")));
	}
	
	
	@Test
	public void testCatagory(){
		System.out.println(new CatagoryDAOImpl(conn).doListCatagories());
	}
	
	
	@Test
	public void testAddCatagory(){
		Catagory c=new Catagory(0);
		c.setDesc("sssssssssssssss");
		System.out.println(new CatagoryDAOImpl(conn).addCatagory(c));
	}
	
	
	@Test
	public void testLogin(){
		System.out.println(new LoginService().loginValidate("ÇØË¸", "123"));
//		System.out.println(new LoginService().loginValidate("ss", "sss"));
	}
}
