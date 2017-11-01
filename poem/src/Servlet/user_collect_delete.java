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

public class user_collect_delete extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mysql.function function = new mysql.function();    
		user user = (user)request.getSession().getAttribute("user");  
		String collect_id = request.getParameter("collect_id");  
		
		function.deleteCollect(user.id, Integer.parseInt(collect_id)); 
		
	    String result = "<p align='right' valign='top'><a href='user_collect_delete?collect_id=0'>取消全部收藏</a></p>";
	    result += function.getCollect(((user)request.getSession().getAttribute("user")).id);    
		
		request.getSession().setAttribute("main_str",result); 
		request.getRequestDispatcher("main.jsp").forward(request, response);
		

	    
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

	}
}




