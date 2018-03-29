package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "회원가입", urlPatterns = { "/insert" })
public class UserInsert extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//한글처리
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("user_id");
		String password = req.getParameter("password");
		String nickName = req.getParameter("nick_name");
		String account = req.getParameter("account");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/project", "postgres","postgres");
			statement = connection.createStatement();
			
			String sql="insert into project (user_id, password, nick_name, account, email, mobile) values" 
						+ "('" +userId+ "','" +password+ "','" +nickName+ "','" +account+ "','" +email+ "','" +mobile+ "')";
			
			int num = statement.executeUpdate(sql);
			
			if(num==1) {
				out.print("저장 성공");
			}else {
				out.print("저장 실패");
			}
			

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement!=null) statement.close();
				if(connection!=null) statement.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		out.print("</body></html>");
	}

}
