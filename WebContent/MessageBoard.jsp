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
body{
	text-align: center;
}
.msgBody {
	text-align: right;
	padding-bottom: 5px;
	padding-top: 5px;
	margin-bottom: 5px;
}

.msgTime {
	text-align: right;
}

.round {
	padding: 10px;
	border: 5px solid blue;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
}

.catagory {
	width: 500px;
	margin: 5px auto;
}

.msgOfMineBody {
	text-align: left;
	padding-bottom: 5px;
	padding-top: 5px;
	margin-bottom: 5px;
}
</style>
</head>
<body >
	<span>当前用户${currentUser}</span>
	<br>
	<br>

	<div>
		留言板:<br>
		<textarea rows="3" cols="10" style="width: 400px;"></textarea>
		<a href="#">留言</a>
	</div>
	<br>
	<div>

		<div class="round catagory">
			<br> <span>第1楼(</span><span style="color: blue">张三</span>)
			<div class="msg">
				<div class="msgBody">你大爷来看你了</div>
				<div class="msgTime">2012-12-12 12:12:12</div>
			</div>
			<div class="msgOfMine">

				<div class="msgOfMineBody">
					<span style="color: blue">我：</span>我是你爷爷
				</div>
				<div class="msgOfMineTime">2012-12-12 12:12:12</div>
			</div>

			<div>
				<textarea rows="1" cols="10"
					style="height: 30px; width: 400; margin-top: 5px;"></textarea>
				<a href="">回复</a>
			</div>
		</div>
	</div>
</body>
</html>