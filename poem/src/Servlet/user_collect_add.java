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

public class user_collect_add extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mysql.function function = new mysql.function();
		//中文处理
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK"); 
		poem poem = function.showPoem(Integer.parseInt(request.getParameter("poem_id")));   
		user user = (user)request.getSession().getAttribute("user"); 
		String text = " ";
		String poem_show = " "; 
		
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
    	
    	String collect = "<p><a href='poem_show?id="+poem.id+"'>" 
    			+	"<font color=#0000FF> <strong>"+poem.name + "</font></strong>"  + " - "
    			+	poem.author + "("
    			+	poem.era + ")" + "<br>"
    			+   text 
    			+ 	"</a>"  + "<br>"
    			+	"("+date + ")"
    			;
    	int collect_error = function.setCollect(user.id,poem.id,collect);		 
		if(collect_error == -1)
		{
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print(collect+"<script type='' language='javascript'>alert('该诗词已被收藏');history.go(-1);</script>");
			out.flush();
			out.close();
		}
		else if(collect_error == -2)
		{
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print(collect+"<script type='' language='javascript'>alert('数据库访问出错');history.go(-1);</script>");
			out.flush();
			out.close();
		}	
		
		request.getSession().setAttribute("main_str",poem_show); 
		request.getRequestDispatcher("main.jsp").forward(request, response);	
		
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
 
	}
}




