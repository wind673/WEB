package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import mysql.poem;

public class poem_find extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mysql.function function = new mysql.function();
		//中文处理
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		//获取用户输入信息 
		String str_find = request.getParameter("str_find"); 
		if(str_find.equals("*1")) str_find = "秦汉";
		else if(str_find.equals("*2")) str_find = "隋唐";
		else if(str_find.equals("*3")) str_find = "宋代";
		else if(str_find.equals("*4")) str_find = "金元";
		else if(str_find.equals("*5")) str_find = "明清";
		
		
		poem[] poem = new poem[1000];
		for(int i = 0;i < 1000;i++)poem[i] = new poem(); 
		
	    int cnt	= function.findPoem(str_find,poem);//得到链接
	    
	    String result = "";
	    String text = "";
	    for(int i = 0;i < cnt;i ++)
	    {
	    	if(poem[i].text.length() > 10) text = poem[i].text.substring(0,10)+"......";//截取前10个字
	    	else text = poem[i].text;
	    		
	    	result += "<p><a href='poem_show?id="+poem[i].id+"'>" 
	    			+	"<font color=#0000FF> <strong>"+poem[i].name + "</font></strong>" + " - "
	    			+	poem[i].author + "("
	    			+	poem[i].era + ")" + "<br>"
	    			+   text  
	    			+ "</a></p>"  
	    			;
	    }
	     
	    if(cnt == -1)
	    {
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('数据库连接出错');history.go(-1);</script>");
			out.flush();
			out.close(); 
	    }
	    else if(cnt > 0)
	    {
			//合法，则保存当前用户信息到session中
			request.getSession().setAttribute("main_str", result); 
			request.getSession().setAttribute("find_poem", poem);   
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	    else if(cnt == 0)
		{
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print(str_find+"<script type='' language='javascript'>alert('没有查找到相关诗词');history.go(-1);</script>");
			out.flush();
			out.close();
		}
	    
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		mysql.function function = new mysql.function();
		//中文处理
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		//获取用户输入信息 
		String str_find = request.getParameter("str_find"); 
		
		poem[] poem = new poem[1000];
		for(int i = 0;i < 1000;i++)poem[i] = new poem(); 
		
	    int cnt	= function.findPoem(str_find,poem);//得到链接
	    
	    String result = "";
	    String text = "";
	    for(int i = 0;i < cnt;i ++)
	    {
	    	if(poem[i].text.length() > 10) text = poem[i].text.substring(0,10)+"......";//截取前10个字
	    	else text = poem[i].text;
	    		
	    	result += "<p><a href='poem_show?id="+poem[i].id+"'>" 
	    			+	"<font color=#0000FF> <strong>"+poem[i].name + "</font></strong>"  + " - "
	    			+	poem[i].author + "("
	    			+	poem[i].era + ")" + "<br>"
	    			+   text  
	    			+ "</a></p>"  
	    			;
	    }
	     
	    if(cnt == -1)
	    {
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('数据库连接出错');history.go(-1);</script>");
			out.flush();
			out.close(); 
	    }
	    else if(cnt > 0)
	    {
			//合法，则保存当前用户信息到session中
			request.getSession().setAttribute("main_str", result); 
			request.getSession().setAttribute("find_poem", poem);   
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	    else if(cnt == 0)
		{
			//如果不合法，则给出提示，并返回到登录页面
			PrintWriter out=response.getWriter();
			out.print(str_find+"<script type='' language='javascript'>alert('没有查找到相关诗词');history.go(-1);</script>");
			out.flush();
			out.close();
		}
	}
}




