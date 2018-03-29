<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	String userId = request.getParameter("userId");
	session.setAttribute("userId", userId);
	session.removeAttribute("password");
%>
<body>
	<h2>비밀번호</h2>
	<fieldset>
		<form action="/ServletTest/join3.jsp">
			<input type="password" name="password" placeholder="비밀번호">
			<input type="submit" value="2단계 전송">
		</form>
	</fieldset>

</body>
</html>