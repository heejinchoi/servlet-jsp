package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 브라우저를 종료하고 다시 접속해도 계속 유지되는 지속적으로 사용해야되는 데이터를 
 * servletcontext 객체의 setAttribute(name, value) 메서드로 저장하고,getArribute(name) 메서드로 참조
 * 
 * @author HJCHOI
 */
@WebServlet("/contextset")
public class ContextSetService extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//속성값 설정
		String name ="최희진";
		int age=26;
		
		getServletContext().setAttribute("name", name);
		getServletContext().setAttribute("age", age);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
