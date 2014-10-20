package com.hyl.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.model.Message;
import com.hyl.service.impl.MessageServiceImpl;

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

			Message message = new Message(0, 0, from, contetn, null);
			if (new MessageServiceImpl().addNewCataAndMsg(message)) {
				response.sendRedirect("ListMessageServlet");
			} else {
				response.getWriter().println("<h1>服务器异常，稍后重试</h1>");
			}
		} else if ("addMsg".equals(request.getParameter("type"))) {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String cidsString = request.getParameter("cid");
			Message m = new Message(0, Integer.parseInt(cidsString.trim()),
					from, content, null);
			if (new MessageServiceImpl().addMsgOnly(m)) {
				response.sendRedirect("ListMessageServlet");

			} else {
				response.getWriter().println("<h1>服务器异常，稍后重试</h1>");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
