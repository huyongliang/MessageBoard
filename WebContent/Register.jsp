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
<title>标题</title>
</head>
<body>
	<div class="main" style="width: 500px; margin: 100px auto;">
		<h1>用户注册</h1>
		<form action="RegisterServlet" method="post">
			用户名:&nbsp;<input type="text" name="userName"><br> <br>
			密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"><br>
			重复密码:<input type="password" name="repassword"><br> <br>
			<input type="submit" value="注册"><a href="index.jsp">返回登录界面</a>
		</form>
	</div>
</body>
</html>