package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import mysql.poem;
import mysql.user;

public class user_history extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		mysql.function function = new mysql.function();
		//中文处理
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK"); 
		
	    String result = "<p align='right' valign='top'><a href='user_history_delete?history_id=0'>删除全部记录</a></p>";
	    result += function.getHistory(((user)request.getSession().getAttribute("user")).id);  
	    
		//合法，则保存当前用户信息到session中
		request.getSession().setAttribute("main_str", result);     
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	    
	}
}




