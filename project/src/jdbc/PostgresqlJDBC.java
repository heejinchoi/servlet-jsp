package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db")
public class PostgresqlJDBC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
	    Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "postgres");
	         con.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM Project;" );
	         while ( rs.next() ) {
	            String userId = rs.getString("user_id");
	            String  password = rs.getString("password");
	            String nickName  = rs.getString("nick_name");
	            String  account = rs.getString("account");
	            String email = rs.getString("email");
	            String mobile = rs.getString("mobile");
	            System.out.println( "Id = " + userId );
	            System.out.println( "password = " + password );
	            System.out.println( "nickName = " + nickName );
	            System.out.println( "account = " + account );
	            System.out.println( "account = " + email );
	            System.out.println( "mobile = " + mobile );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	      }
	      System.out.println("Operation done successfully");
	   }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
