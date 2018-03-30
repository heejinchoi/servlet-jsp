package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ContextParam extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//컨텍스트 파라미터 얻기
		String path = getServletContext().getInitParameter("path");
		String dataPath = getServletContext().getInitParameter("dataPath");
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("경로: " + path	 + "<br>");
		out.print("데이터 경로: " + dataPath	 + "<br>");
		out.print("</body></html>");
		
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	
	}

}
