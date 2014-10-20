package com.hyl.dao;

import java.sql.Connection;

import org.junit.Test;

import com.hyl.DBUtils;
import com.hyl.dao.impl.CatagoryDAOImpl;
import com.hyl.model.Catagory;

public class CatagoryDAOTest {
	private Connection conn = null;

	{
		conn = DBUtils.getConnection();
	}

	@Test
	public void testDoListCatagories() {

		System.out.println(new CatagoryDAOImpl(conn).doListCatagories());

	}

	@Test
	public void testDoCreateCatagory() {
		System.out.println(new CatagoryDAOImpl(conn)
				.doCreateCatagory(new Catagory(0, "sss")));
	}

}
