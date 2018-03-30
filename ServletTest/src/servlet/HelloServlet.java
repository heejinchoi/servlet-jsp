package com.gaia3d.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="MyServlet", urlPatterns= {"/testGet", "/testPost", "/testParam"})
public class HelloServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 요청");
	}

	public void destroy() {	
		System.out.println("destroy 요청");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HelloServlet doGet 요청!");
		
		//MIME 타입 설정
		res.setContentType("text/html; charset=UTF-8");
		
		//자바 IO
		PrintWriter writer = res.getWriter();
		
		//html 작성
		writer.print("<html><body>");
		writer.print("ResponseServlet 요청 성공" + "<br>");
		writer.print("</body></html>");
		
		//실습폼 - 1
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		writer.print("<html><body>");
		writer.print("아이디 : " + userId + "<br>");
		writer.print("비밀번호 : " + password + "<br>");
		writer.print("</body></html>");
		
		//실습폼 - 2
		String[] hobby = req.getParameterValues("hobby");
		String useYn = req.getParameter("useYn");
		
		writer.print("<html><body>");
		writer.print("좋아하는 취미 활동" + "<br>");
		int count = 0;
		for(String favoritHobby : hobby) {
			count++;
			writer.print(count + "." + favoritHobby + "<br>");
		}
		
		writer.print("사용여부: " + useYn);
		writer.print("</body></html>");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HelloServlet doPost 요청!");
		
		//MINE 타입 설정 + 한글처리
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		//실습 폼 - 3
		Enumeration<String> enu = req.getParameterNames();  //Enumeration 인터페이스는 Iterator와 비슷한 목적으로 사용된다. 
															//보통 Vector나 HashTable 객체에서 제공하는 메소드로 그 객체를 생성한다.
		
		PrintWriter writer = res.getWriter();
		writer.print("<html><body>");
		while (enu.hasMoreElements()) {
			String userId = enu.nextElement();
			String userIdVal = req.getParameter(userId);
			String password = enu.nextElement();
			String passwordVal = req.getParameter(password);
			String mobile = enu.nextElement();
			String mobileVal = req.getParameter(mobile);
			String email = enu.nextElement();
			String emailVal = req.getParameter(email);
			writer.print("아이디: " + userIdVal + "<br>");
			writer.print("비밀번호: " + passwordVal + "<br>");
			writer.print("휴대폰: " + mobileVal  + "<br>");
			writer.print("이메일:  " + emailVal + "<br>");
		}
		writer.print("</body></html>");
		
	}
	
	protected void param(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

	}
	
	
}
