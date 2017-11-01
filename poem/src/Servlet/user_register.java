package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class user_register extends HttpServlet {

	private static final long serialVersionUID = 8550471953557376897L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		mysql.function function = new mysql.function();
		mysql.user user = new mysql.user();
		
		//中文处理
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		//获取用户输入信息
		user.user = request.getParameter("user"); 
		user.name = request.getParameter("name"); 
		user.password = request.getParameter("password"); 
		user.sex = request.getParameter("sex"); 
		user.school = request.getParameter("school"); 
		user.email = request.getParameter("email");  
		int error = function.registerUser(user);
		
		//创建用户业务类对象，并调用方法进行验证当前用户是否为合法用户 
		if(user.user.equals(""))
		{
			//如果不合法，则给出提示，并返回到登录页面 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('用户名不能为空');history.go(-1);</script>");
			out.flush();
			out.close();
		} 
		else if(error == 1)
		{
			//如果不合法，则给出提示，并返回到登录页面 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('用户名已存在');history.go(-1);</script>");
			out.flush();
			out.close();
		}
		else if(error == 2)
		{
			//如果不合法，则给出提示，并返回到登录页面 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('数据库连接失败2');history.go(-1);</script>");
			out.flush();
			out.close();
		}
		else if(error == 3)
		{
			//如果不合法，则给出提示，并返回到登录页面 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('数据库连接失败3');history.go(-1);</script>");
			out.flush();
			out.close();
		}
		
		else 
		{
			String mian_str =  
					 "&nbsp<p><font color=#0000FF> <strong>用户：" + user.user	+ " </strong></font> </p>"
						+ "<p><font color=#0000FF> <strong>姓名：" + user.name 	+ " </strong></font> </p>"
						+ "<p><font color=#0000FF> <strong>性别：" + user.sex 	+ " </strong></font> </p>"
						+ "<p><font color=#0000FF> <strong>学校：" + user.school	+ " </strong></font> </p>"
						+ "<p><font color=#0000FF> <strong>邮箱：" + user.email 	+ " </strong></font> </p>" 
						+ "<p><a href='user_change.jsp'>修改</a></p>";
			
			//合法，则保存当前用户信息到session中
			request.getSession().setAttribute("user", user); 
			request.getSession().setAttribute("user_password", user.password);
			request.getSession().setAttribute("user_name", user.name);
			request.getSession().setAttribute("user_sex", user.sex);
			request.getSession().setAttribute("user_school", user.school);
			request.getSession().setAttribute("user_email", user.email); 
			
			request.getSession().setAttribute("main_str", mian_str);
			request.getRequestDispatcher("main.jsp").forward(request, response);
			
		} 
	}
}




