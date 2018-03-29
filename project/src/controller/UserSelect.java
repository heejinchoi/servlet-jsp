package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "회원조회", urlPatterns = { "/select" })
public class UserSelect extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://127.0.0.1:5432/project";
		String pgUser = "postgres";
		String pgPassword = "postgres";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, pgUser, pgPassword);
			statement = connection.createStatement();
			String sql = "select user_id, password, nick_name, account, email, mobile from project";
			resultSet = statement.executeQuery(sql);
			System.out.println(connection);
			System.out.println(statement);
			System.out.println(resultSet);
			
			while(resultSet.next()) {
				String userId = resultSet.getString("user_id");	
				String password = resultSet.getString("password");	
				String nickName = resultSet.getString("nick_name");	
				String account = resultSet.getString("account");	
				String email = resultSet.getString("email");	
				String mobile = resultSet.getString("mobile");	
				
				out.println(userId + "\t" + password + "\t" + nickName + "\t" + account + "\t" + email + "\t" + mobile + "<br>");
			}	
			
		} catch (Exception e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			
		} finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();
				if(connection!=null) statement.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		out.print("</body></html>");
	}

	

}
