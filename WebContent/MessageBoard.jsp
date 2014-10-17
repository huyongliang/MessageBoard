<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
body {
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
	border: 3px solid blue;
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

.msgs {
	padding: 10px;
	border: 1px solid blue;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
	width: 550px;
	margin:10px auto;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<span>当前用户${currentUser}</span>
	<br>
	<br>

	<div>
		留言板:<br>
		<textarea name="msgContent" rows="3" cols="10" style="width: 400px;"></textarea>
		<a href="#">留言</a>
	</div>
	<br>
	<div class="msgs">

		<c:forEach items="${catagories}" var="c">
			<div class="round catagory">
				<div style="text-align: left; font-size: 20px;">
					<span>第${c.id}楼(</span><span style="color: blue">${c.desc}</span>)
				</div>
				<c:forEach items="${c.messages}" var="m">
					<div class="msg">
						<div class="msgBody">
							<div style="text-align: left;">${m.from}:</div>
							<div style="padding: 5px 10px;">${m.content}</div>
						</div>
						<div class="msgTime">${m.time }</div>
						<hr style="color: green;">
					</div>
				</c:forEach>
				<br>
				<div>
					<textarea rows="1" cols="10"
						style="height: 30px; width: 400; margin-top: 5px;"></textarea>
					<a href="">开始扯淡</a>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>