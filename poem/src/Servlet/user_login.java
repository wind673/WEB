package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class user_login extends HttpServlet {

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
		//获取用户输入信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//创建用户业务类对象，并调用方法进行验证当前用户是否为合法用户 
		int error = 0;
		if(name.isEmpty()) error = -1;
		
		if(error == 0)
		{
			mysql.user user = new mysql.user();
			user = function.getUser(name, password);
			
			if(user != null)
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
				request.getSession().setAttribute("user_id", user.id);
				
				request.getSession().setAttribute("main_str", mian_str);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			else
			{
				//如果不合法，则给出提示，并返回到登录页面
				
				PrintWriter out=response.getWriter();
				out.print("<script type='' language='javascript'>alert('用户名或密码错误，请重新输入。');history.go(-1);</script>");
				out.flush();
				out.close();
			}
		}
		else
		{
			//如果不合法，则给出提示，并返回到登录页面 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('用户名不能为空');history.go(-1);</script>");
			out.flush();
			out.close();
		}
			
	}
}




