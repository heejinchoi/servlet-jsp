<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//쿠키 삭제
	//setMaxAge(0) : 바로 삭제
	//setMaxAge(-1) : 브라우저를 닫으면 삭제
	
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		System.out.println(c.getName());
		if(c.getName().equals("userId")){
			c.setMaxAge(0);
			response.addCookie(c);	//쿠키를 변경한 후에는 브라우저에게 전송
			break;
		}
	}

%>
