package Servlet;

import java.io.IOException;
import java.io.PrintWriter; 
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import mysql.poem;
import mysql.user;

public class user_history_delete extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mysql.function function = new mysql.function();    
		user user = (user)request.getSession().getAttribute("user");  
		String history_id = request.getParameter("history_id");  
		
		function.deleteHistory(user.id, Integer.parseInt(history_id)); 
		
	    String result = "<p align='right' valign='top'><a href='user_history_delete?history_id=0'>É¾³ýÈ«²¿¼ÇÂ¼</a></p>";
	    result += function.getHistory(((user)request.getSession().getAttribute("user")).id);    
		
		request.getSession().setAttribute("main_str",result); 
		request.getRequestDispatcher("main.jsp").forward(request, response);
		

	    
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

	}
}




