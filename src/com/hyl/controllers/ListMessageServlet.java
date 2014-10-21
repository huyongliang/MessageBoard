package com.hyl.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.model.Catagory;
import com.hyl.service.impl.CatagoryServiceImpl;

public class ListMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Catagory> catagories = null;
		try {
			catagories = new CatagoryServiceImpl().getAllCatagoriesWithMsg();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		request.setAttribute("catagories", catagories);
		request.getRequestDispatcher("/MessageBoard.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
