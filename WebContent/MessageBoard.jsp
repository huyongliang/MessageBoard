<%@page import="com.hyl.model.Message"%>
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
	/* background-image: url("img/bg_blank.png"); */
}

.msgBody {
	/* text-align: right; */
	padding-bottom: 5px;
	padding-top: 5px;
	margin-bottom: 5px;
	vertical-align: middle;
}

.msgTime {
	/* text-align: right; */
	
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
	background-color: #4B83BC;
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
	margin: 10px auto;
	padding: 5px 10px;
}

.left {
	text-align: left;
}

.right {
	text-align: right;
}

.msg {
	border-bottom: 1px solid blue;
	border-top: 1px solid blue;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
}

.messageBoard {
	width: 500px;
	margin: 10px auto;
	background-color: #4B83BC;
	padding: 0;
}
</style>

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#addMsgOrCataGory").click(function() {
			if (($("#board").val() == null) || ($("#board").val() == "")) {
				alert("请输入有效信息");
				return false;
			}
		});

		$(".addToChat").click(function() {
			var d = $(this).parent();
			var content = $(d).find("textarea").val();
			if (content == null || content == "") {
				alert("请输入有效信息");
				return false;
			}
		});
	});
</script>

<script type="text/javascript">
	
</script>

</head>
<body>

	<span style="color: blue; font-size: 20px;">当前用户 ${currentUser}</span>
	<br>
	<br>

	<div class="round messageBoard">
		留言板:<br>
		<form action="MessageServlet">
			<input type="hidden" name="from" value="${currentUser}"> <input
				type="hidden" name="type" value="addCatagory">
			<textarea id="board" name="msgContent" rows="3" cols="10"
				style="width: 100%;"></textarea>
			<br> <input id="addMsgOrCataGory" type="submit" value="留言">
		</form>
	</div>
	<br>

	<c:if test="${catagories.size()<=0}">
		<div>暂时没有留言，你可以做第一个留言者。</div>
	</c:if>
	<div class="msgs">
		<c:set var="index" scope="page" value="0"></c:set>
		<c:forEach items="${catagories}" var="c">
			<div class="round catagory">
				<div style="text-align: left; font-size: 20px;">
					<img alt="" src="img/house_blue_24.png"><span>#${c.id}(</span><span style="color: blue">${c.desc}</span>)
				</div>


				<c:forEach items="${c.messages}" var="m">




					<c:choose>
						<c:when test="${index%2==0}">

							<div class="msg left">
								<div class="msgBody">
									<div style="color: blue">
										&nbsp;<img src="img/user.png" width="20px;" height="20px;" />&nbsp;${m.from}:
									</div>
									<div style="padding: 5px 10px;">
										<img alt="" src="img/message_blue_24.png"> ${m.content}
									</div>
								</div>
								
								<div class="msgTime">${m.time.toLocaleString() }</div>
								<hr style="color: green;">
							</div>
						</c:when>
						<c:otherwise>

							<div class="msg right">
								<div class="msgBody">
									<div style="color: blue">
										<img src="img/user.png" width="20px;" height="20px;" />&nbsp;${m.from}:
									</div>
									<div style="padding: 5px 10px;">
										<img alt="" src="img/message_blue_24.png">&nbsp;${m.content}</div>
								</div>
								<div class="msgTime">${m.time.toLocaleString() }</div>
								<hr style="color: green;">
							</div>

						</c:otherwise>

					</c:choose>
					<c:set var="index" value="${index+1}"></c:set>




				</c:forEach>
				<br>
				<form action="MessageServlet">
					<input type="hidden" name="type" value="addMsg"> <input
						type="hidden" name="from" value="${currentUser}"> <input
						type="hidden" name="cid" value="${c.id}"> <img
						src="img/edit_blue_48.png" />
					<textarea name="content" rows="2" cols="10"
						style="height: 50px; width: 400; margin-top: 5px;"></textarea>


					<input class="addToChat" type="submit" value="我也说一句">
				</form>
			</div>
		</c:forEach>

	</div>
	
	
	
</body>
</html>