<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//쿠키 읽기
	public String getCookie(Cookie[] cookies, String key){
		//Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals(key)){
				//out.print("userId 로 저장된 쿠키값: " + c.getValue());
				//break;
				
				return c.getValue();
			} 
		}
		return null;
	}
%>	
<%

	try{
	
	//쿠키를 생성 : 키, 값
	Cookie cookie = new Cookie("userId", "snooper");
	response.addCookie(cookie); 	//응답을 통해서 클라이언트 브라우저 전송
	
	//쿠키 읽기
	out.println("처음의 쿠키: " + getCookie(request.getCookies(), "userId"));
	
	//쿠키 수정 - 동일한 키값으로 덮어쓰기
	Cookie cookie2 = new Cookie("userId", "h2jin1");
	response.addCookie(cookie2);
	
	//쿠키 읽기
	out.println("변경된 후 쿠키값: " + getCookie(request.getCookies(), "userId"));
	
	}catch(Exception e){
		out.print("에러 발생!");
		e.printStackTrace();
	}
	
%>