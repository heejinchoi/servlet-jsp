<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//��Ű ����
	//setMaxAge(0) : �ٷ� ����
	//setMaxAge(-1) : �������� ������ ����
	
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		System.out.println(c.getName());
		if(c.getName().equals("userId")){
			c.setMaxAge(0);
			response.addCookie(c);	//��Ű�� ������ �Ŀ��� ���������� ����
			break;
		}
	}

%>
