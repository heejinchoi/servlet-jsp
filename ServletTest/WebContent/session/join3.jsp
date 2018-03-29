<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String password = request.getParameter("password");
	session.setAttribute("password", password);
	session.removeAttribute("nickName");

%>
<body>
	<h2>닉네임</h2>
	<fieldset>
		<form action="/ServletTest/result.jsp">
			<input type="text" name="nickName" placeholder="별명">
			<input type="submit" value="3단계 전송">
		</form>
	</fieldset>
</body>
</html>