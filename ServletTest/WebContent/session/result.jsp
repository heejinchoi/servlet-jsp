<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String nickName = request.getParameter("nickName");
	session.setAttribute("nickName", nickName);

%>
userId : <%= session.getAttribute("userId")%><br>
password : <%= session.getAttribute("password")%><br>
nickName : <%= session.getAttribute("nickName")%><br>

<%
	session.invalidate();
%>


	<a href="result2.jsp">메인화면으로 이동</a>
</body>
</html>