package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class user_show extends HttpServlet
{

    private static final long serialVersionUID = 8550471953557376897L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {

        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    { 
        //���Ĵ���
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        //��ȡ�û�������Ϣ
        mysql.user user = (mysql.user) request.getSession().getAttribute("user");

        String mian_str =
        "&nbsp<p><font color=#0000FF> <strong>�û���" + user.user	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>������" + user.name 	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>�Ա�" + user.sex 	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>ѧУ��" + user.school	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>���䣺" + user.email 	+ " </strong></font> </p>"
        + "<p><a href='user_change.jsp'>�޸�</a></p>";

        //�Ϸ����򱣴浱ǰ�û���Ϣ��session�� 
        request.getSession().setAttribute("main_str", mian_str);
        request.getRequestDispatcher("main.jsp").forward(request, response);
 
    }
}




