<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>标题</title>

<style type="text/css">
.main {
	text-align: center;
	width: 400px;
	padding: 10px;
	border: 5px solid blue;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
	margin: 150px auto;
}
</style>
</head>
<body>
	<div class="main">
		<h1>登陆</h1>
		<form action="LoginServlet" method="post">
			用户名:<input type="text" name="userName"><br> <br>
			密&nbsp;&nbsp;码:<input type="password" name="password"><br><br>
			<input type="submit" value="登陆">
			<a href="#">注册</a>
		</form>
	</div>
</body>
</html>