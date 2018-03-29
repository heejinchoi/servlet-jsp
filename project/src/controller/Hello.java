package controller;

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.text.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet
{ 
  Connection db;  
  Statement  st;
  PrintWriter out;

  public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
   String title = "Example Apache JServ Servlet";
   response.setContentType("text/html");
   out = response.getWriter();
   out.println("<HTML><HEAD><TITLE>");
   out.println(title);
   out.println("</TITLE></HEAD><BODY bgcolor=\"#FFFFFF\">");
   out.println("<H1>" + title + "</H1>");
   out.println("<H2>Congratulations, Apache JServ is working!</H2>");
   try {
        test();
       } catch(Exception ex){
          out.println("<h2>DB error!</h2>");
         }
   out.println("</BODY></HTML>");
   out.close();
   }

   public void cleanup()
   {  
     try {
         st.executeUpdate("drop table basic");
       } catch(Exception ex) {  }
   }
         
   public void doexample() throws SQLException
   {
     out.println("<br><h2>Running tests:</h2>");
     st.executeUpdate("create table basic (a int2, b int2)");
     st.executeUpdate("insert into basic values (1,1)");
     st.executeUpdate("insert into basic values (2,1)");
     st.executeUpdate("insert into basic values (3,1)");
     st.executeUpdate("update basic set b=8");
     out.println("<h2>Updated "+st.getUpdateCount()+" rows</h2>");
     PreparedStatement ps = db.prepareStatement("insert into basic values (?,?)");
     for(int i=2;i<5;i++) {
            ps.setInt(1,4);             // "column a" = 5
            ps.setInt(2,i);             // "column b" = i
            ps.executeUpdate(); 
      }
     ps.close();                
     out.println("<h2>performing a query</h2>");
     ResultSet rs = st.executeQuery("select a, b from basic");
     if(rs!=null) {
         while(rs.next()) {
               int a = rs.getInt("a");
               int b = rs.getInt(2); 
               out.println("<h2>  a="+a+" b="+b+"</h2>");
          }
         rs.close(); 
     }
   }

   public void  test() throws ClassNotFoundException, FileNotFoundException, IOException,SQLException { 
    String url = "jdbc:postgresql://127.0.0.1:5432/project";  
    String usr = "postgres";  
    String pwd = "postgres";
    Class.forName("postgresql.Driver");
    db = DriverManager.getConnection(url, usr, pwd);
    out.println("<h2>Connecting to Database URL = " + url +"</h2>");
    out.println("<h2>Connected...Now creating a statement</h2>");
    st = db.createStatement();
    cleanup();    
    doexample();    
    cleanup();
    out.println("<h2>Now closing the connection</h2>");
    st.close();   
    db.close();
   }//end test
 }
