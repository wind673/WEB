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
        //中文处理
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        
        //获取用户输入信息
        mysql.user user = (mysql.user) request.getSession().getAttribute("user");

        String mian_str =
        "&nbsp<p><font color=#0000FF> <strong>用户：" + user.user	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>姓名：" + user.name 	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>性别：" + user.sex 	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>学校：" + user.school	+ " </strong></font> </p>"
        + "<p><font color=#0000FF> <strong>邮箱：" + user.email 	+ " </strong></font> </p>"
        + "<p><a href='user_change.jsp'>修改</a></p>";

        //合法，则保存当前用户信息到session中 
        request.getSession().setAttribute("main_str", mian_str);
        request.getRequestDispatcher("main.jsp").forward(request, response);
 
    }
}




