<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	session.removeAttribute("userId");
%>
<body>
	<h2>이메일</h2>
	<fieldset>
		<form action="/ServletTest/join2.jsp">
			<input type="text" name="userId" placeholder="이메일">
			<input type="submit" value="1단계 전송">
		</form>
	</fieldset>
</body>
</html>