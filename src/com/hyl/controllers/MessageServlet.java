package com.hyl.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.DBUtils;
import com.hyl.dao.MessageDAOImpl;
import com.hyl.model.Message;
import com.hyl.service.MessageService;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if ("addCatagory".equals(request.getParameter("type"))) {

			String contetn = request.getParameter("msgContent");
			String from = request.getParameter("from");
			System.out.println("=====:" + contetn);

			Message message = new Message(0, 0, from, null, contetn, new Date());
			Connection conn = DBUtils.getConnection();
			try {
				if (new MessageService(conn).addCatagoryAndMsg(message)) {
					response.sendRedirect("ListMessageServlet");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.release(null, null, conn);
			}
		} else if ("addMsg".equals(request.getParameter("type"))) {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String cidsString = request.getParameter("cid");
			Message m = new Message(0, Integer.parseInt(cidsString.trim()),
					from, null, content, new Date());
			Connection conn = DBUtils.getConnection();
			try {
				if (new MessageDAOImpl(conn).doCreate(m)) {
					response.sendRedirect("ListMessageServlet");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.release(null, null, conn);
			}

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
