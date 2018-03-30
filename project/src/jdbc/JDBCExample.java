package jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PostgreSQL 연결
 * @author HJCHOI
 *
 */
public class JDBCExample {
	public static void main(String[] args) throws SQLException {
/*		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/데이터베이스명", "pg아이디", "pg비밀번호");
			connection.close();
					
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
*/
		
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			//PostgreSQL JDBC driver를 추가하지 않았을 경우.
			//http://jdbc.postgresql.org/download.html 에서 postgresql-9.3-1104.jdbc41.jar 다운
			//프로젝트 우클릭-Properties-build path-library-Add JAR
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/project", "postgres","postgres");

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			
			st = connection.createStatement();
			System.out.println("@@@" +st);
			String sql = "select * from project";
			rs = st.executeQuery(sql);
			String userId= rs.getString("user_id");
			System.out.println("----------" + userId);
			

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		finally {
			 rs.close(); 
			 st.close(); 
			 connection.close(); 
		}

		
		
		
	}
	
	
	
/*	public void test() throws ClassNotFoundException, FileNotFoundException, IOException,SQLException {
		Connection db;  
		Statement  st;

		String url = "jdbc:postgresql://127.0.0.1:5432/project";  
	    String usr = "postgres";  
	    String pwd = "postgres";
	    
	    Class.forName("org.postgresql.Driver");
	    db = DriverManager.getConnection(url, usr, pwd);
	    st = db.createStatement();
	    
	    System.out.println(db);
	    System.out.println(st);
	    
//	    cleanup();    
//	    doexample();    
//	    cleanup();
	    st.close();   
	    db.close();
		
	}
	*/
	
	
}
