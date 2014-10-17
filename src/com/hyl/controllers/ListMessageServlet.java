package com.hyl.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.DBUtils;
import com.hyl.dao.CatagoryDAOImpl;
import com.hyl.model.Catagory;

public class ListMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection conn = DBUtils.getConnection();
		List<Catagory> catagories = null;
		try {
			catagories = new CatagoryDAOImpl(conn).doListCatagories();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(null, null, conn);
		}

		request.setAttribute("catagories", catagories);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
