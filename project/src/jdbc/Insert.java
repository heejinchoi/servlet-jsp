package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc/insert")
public class Insert extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "postgres");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO user_info1 (user_id, password, nick_name, account, email, mobile) "
	            + "VALUES ('test1', '789', 'AA', '20457-89675', 'ee@daum.net', '010-5793-3157' );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO user_info1 (user_id, password, nick_name, account, email, mobile) "
	            + "VALUES ('test2', '456', 'BB', '856421-532144', 'ww@naver.com', '010-8765-4463' );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO user_info1 (user_id, password, nick_name, account, email, mobile)"
	            + "VALUES ('test3', '963', 'CC', '633474-532161', 'qq@gmial.com', '010-7595-7234' );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
