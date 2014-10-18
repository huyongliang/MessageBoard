package com.hyl.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.DBUtils;
import com.hyl.dao.UserDAOImpl;
import com.hyl.model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		User user = new User(userName, password);

		Connection conn = DBUtils.getConnection();
		try {
			if (new UserDAOImpl(conn).doCreate(user)) {
				// request.getRequestDispatcher("/index.jsp").forward(request,
				// response);

				response.getWriter().println("×¢²á³É¹¦<br>");
				response.getWriter().println("<a href=\"index.jsp\">·µ»ØµÇÂ¼</a>");
			} else {
				response.getWriter().println("×¢²áÊ§°Ü,ÉÔºóÖØÊÔ£¡");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(null, null, conn);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
