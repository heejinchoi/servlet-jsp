package com.gaia3d.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file")
public class FileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//파일 읽기
		String readFile = "/WEB-INF/write3.txt";
		InputStream is = getServletContext().getResourceAsStream(readFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = res.getWriter();
		writer.print("<html><body>");
		String str = reader.readLine();
		while(str != null) {
			writer.println(str + "<br>");
			str = reader.readLine();
		}
		reader.close();
		writer.print("</body></html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	
	}

}
