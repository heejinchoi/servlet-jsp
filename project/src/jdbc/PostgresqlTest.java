package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PostgresqlTest {
   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "postgres");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
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
            System.out.println( "email = " + email );
            System.out.println( "mobile = " + mobile );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }

}
