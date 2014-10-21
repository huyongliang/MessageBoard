package com.hyl.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogInFilter implements Filter {

	public LogInFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String ctxPath = httpReq.getContextPath();

		String request_uri = httpReq.getRequestURI();

		String uri = request_uri.substring(ctxPath.length());
		// 判断用户访问的是否是登录页面
		if (uri.equals("/LoginServlet")||uri.equals("/") || uri.equals("/index.jsp")
				|| uri.equals("/Register.jsp")||uri.equals("/RegisterServlet")) {
			chain.doFilter(request, response);
			return;
		} else {
			httpReq.getSession(true);
			if (httpReq.getSession().getAttribute("currentUser") == null) {
				httpReq.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return ;
			}
		}
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
