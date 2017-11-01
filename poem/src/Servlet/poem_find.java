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
		//���Ĵ���
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		//��ȡ�û�������Ϣ 
		String str_find = request.getParameter("str_find"); 
		if(str_find.equals("*1")) str_find = "�غ�";
		else if(str_find.equals("*2")) str_find = "����";
		else if(str_find.equals("*3")) str_find = "�δ�";
		else if(str_find.equals("*4")) str_find = "��Ԫ";
		else if(str_find.equals("*5")) str_find = "����";
		
		
		poem[] poem = new poem[1000];
		for(int i = 0;i < 1000;i++)poem[i] = new poem(); 
		
	    int cnt	= function.findPoem(str_find,poem);//�õ�����
	    
	    String result = "";
	    String text = "";
	    for(int i = 0;i < cnt;i ++)
	    {
	    	if(poem[i].text.length() > 10) text = poem[i].text.substring(0,10)+"......";//��ȡǰ10����
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
			//������Ϸ����������ʾ�������ص���¼ҳ��
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('���ݿ����ӳ���');history.go(-1);</script>");
			out.flush();
			out.close(); 
	    }
	    else if(cnt > 0)
	    {
			//�Ϸ����򱣴浱ǰ�û���Ϣ��session��
			request.getSession().setAttribute("main_str", result); 
			request.getSession().setAttribute("find_poem", poem);   
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	    else if(cnt == 0)
		{
			//������Ϸ����������ʾ�������ص���¼ҳ��
			PrintWriter out=response.getWriter();
			out.print(str_find+"<script type='' language='javascript'>alert('û�в��ҵ����ʫ��');history.go(-1);</script>");
			out.flush();
			out.close();
		}
	    
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		mysql.function function = new mysql.function();
		//���Ĵ���
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		//��ȡ�û�������Ϣ 
		String str_find = request.getParameter("str_find"); 
		
		poem[] poem = new poem[1000];
		for(int i = 0;i < 1000;i++)poem[i] = new poem(); 
		
	    int cnt	= function.findPoem(str_find,poem);//�õ�����
	    
	    String result = "";
	    String text = "";
	    for(int i = 0;i < cnt;i ++)
	    {
	    	if(poem[i].text.length() > 10) text = poem[i].text.substring(0,10)+"......";//��ȡǰ10����
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
			//������Ϸ����������ʾ�������ص���¼ҳ��
			PrintWriter out=response.getWriter();
			out.print("<script type='' language='javascript'>alert('���ݿ����ӳ���');history.go(-1);</script>");
			out.flush();
			out.close(); 
	    }
	    else if(cnt > 0)
	    {
			//�Ϸ����򱣴浱ǰ�û���Ϣ��session��
			request.getSession().setAttribute("main_str", result); 
			request.getSession().setAttribute("find_poem", poem);   
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	    else if(cnt == 0)
		{
			//������Ϸ����������ʾ�������ص���¼ҳ��
			PrintWriter out=response.getWriter();
			out.print(str_find+"<script type='' language='javascript'>alert('û�в��ҵ����ʫ��');history.go(-1);</script>");
			out.flush();
			out.close();
		}
	}
}




