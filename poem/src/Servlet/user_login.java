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
		//���Ĵ���
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		//��ȡ�û�������Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//�����û�ҵ������󣬲����÷���������֤��ǰ�û��Ƿ�Ϊ�Ϸ��û� 
		int error = 0;
		if(name.isEmpty()) error = -1;
		
		if(error == 0)
		{
			mysql.user user = new mysql.user();
			user = function.getUser(name, password);
			
			if(user != null)
			{
				String mian_str =  
						 "&nbsp<p><font color=#0000FF> <strong>�û���" + user.user	+ " </strong></font> </p>"
							+ "<p><font color=#0000FF> <strong>������" + user.name 	+ " </strong></font> </p>"
							+ "<p><font color=#0000FF> <strong>�Ա�" + user.sex 	+ " </strong></font> </p>"
							+ "<p><font color=#0000FF> <strong>ѧУ��" + user.school	+ " </strong></font> </p>"
							+ "<p><font color=#0000FF> <strong>���䣺" + user.email 	+ " </strong></font> </p>" 
							+ "<p><a href='user_change.jsp'>�޸�</a></p>";
							
				//�Ϸ����򱣴浱ǰ�û���Ϣ��session��
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
				//������Ϸ����������ʾ�������ص���¼ҳ��
				
				PrintWriter out=response.getWriter();
				out.print("<script type='' language='javascript'>alert('�û���������������������롣');history.go(-1);</script>");
				out.flush();
				out.close();
			}
		}
		else
		{
			//������Ϸ����������ʾ�������ص���¼ҳ�� 
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('�û�������Ϊ��');history.go(-1);</script>");
			out.flush();
			out.close();
		}
			
	}
}




