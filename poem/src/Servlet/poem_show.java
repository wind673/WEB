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

public class poem_show extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mysql.function function = new mysql.function();   
		int id = Integer.parseInt(request.getParameter("id"));
		user user = (user)request.getSession().getAttribute("user"); 
		poem poem = function.showPoem(id);   
		String poem_show = " "; 
		String text = " ";
		
		if(poem != null)
		{
			poem_show =  "<p align='right' valign='top'><a href='user_collect_add?poem_id="+poem.id+"'>"
					   + "<img src='image/collect.gif' width='42' height='42' border='0' />"+"</a>"
					   + "<br>(收藏)<br><br><br></p>"
					   ;

			
			poem_show +="<font color=#0000FF> <strong>" + poem.name +" </strong>"+ " - " 
    			+	poem.author + "("
    			+	poem.era + ")" + "<br>"
    			+   poem.text  + "<br>" + "<br></font>"
    			+	"<font color=#CC3333> <strong>"
    			+	"---------------------------------------------------------" + "<br>"  
    			+	"---------------------------------------------------------" + "<br><br></font></strong>"  
    			+	poem.explain + "<br>" ; 	 
			
	    	if(poem.text.length() > 10) text = poem.text.substring(0,10)+"......";//截取前10个字
	    	else text = poem.text;
	    	
	    	String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    	String history = "<p><a href='poem_show?id="+poem.id+"'>" 
	    			+	"<font color=#0000FF> <strong>"+poem.name + "</font></strong>" + " - "
	    			+	poem.author + "("
	    			+	poem.era + ")" + "<br>"
	    			+   text 
	    			+ 	"</a>"  + "<br>"
	    			+	"("+date + ")"
	    			;
	    			
	    	
			function.setHistory(user.id, history);//记录访问历史记录 
		}
		else poem_show = "查看失败";
		 
		request.getSession().setAttribute("main_str",poem_show); 
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

	}
}




