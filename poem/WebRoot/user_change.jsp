<%@page contentType="text/html" pageEncoding="GBK" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>无标题文档</title>
<!-- TemplateEndEditable --><!-- TemplateBeginEditable name="head" --><!-- TemplateEndEditable --><!-- TemplateParam name="OptionalRegion1" type="boolean" value="true" -->
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
}
.STYLE2 {
	font-size: 24px;
	font-family: "宋体";
}
.STYLE3 {font-size: 12px}
body {
	background-image: url();
	background-repeat: no-repeat;
	background-color: #BBB18E;
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="user_change">
  <table width="1000" height="574" border="0" align="center" bordercolor="#FFFFFF" background="image/petal.gif" bgcolor="#D9D3AF">
    <tr>
      <td width="333" height="59" align="center" background="image/background_up1.jpg">&nbsp;</td>
      <td width="333" align="center" background="image/background_up2.jpg"><span class="STYLE1">古诗词欣赏</span></td>
      <td width="238" align="center" background="image/background_up3.jpg">&nbsp;</td>
      <td height="59" align="center" background="image/background_up3.jpg"><span class="STYLE1"><img src="image/bainiao.gif" width="80" height="59" /></span></td>
    </tr>
    <tr>
      <td height="20" colspan="4" align="left" background="image/background_up3.jpg">
    <label></label>    </tr>
    <tr>
      <td height="7" colspan="4" align="left">
       <a href="main.jsp">返回主页</a>
       </td>
    </tr>
    <tr>
      <td colspan="3" rowspan="2" align="left" valign="top" background="image/butterfly.gif" bgcolor="#F7F2DF"><!-- TemplateBeginIf cond="OptionalRegion1" --><!-- TemplateBeginEditable name="EditRegion3" -->
        <div align="center">
        <img src="image/background_main.jpg" width="910" height="130" align="top" />
		   <!------------------------------------------编辑区域 ------------------------------------------>
		    <p>
            <label>密码 ：
            <input type="password" name="password" value = <%=request.getSession().getAttribute("user_password")%> />
            </label>
          </p>
          <p>
            <label>姓名 ：
            <input type="text" name="name" value = <%=request.getSession().getAttribute("user_name")%> />
            </label>
          </p>
          <p>
            <label>性别 ：
            <input type="text" name="sex" value = <%=request.getSession().getAttribute("user_sex")%> />
            </label>
          </p> 
          <p>
            <label>学校 ：
            <input type="text" name="school" value = <%=request.getSession().getAttribute("user_school")%> />
            </label>
          </p>
          <p>
            <label>email：
            <input type="text" name="email" value = <%=request.getSession().getAttribute("user_email")%> />
            </label>
          </p>
          
          <p>
            <label></label> 
            <input name="user_change" type="submit"  value="修改" /> 
          </p>
            <!------------------------------------------编辑结束 ------------------------------------------>  
        </div>
      <!-- TemplateEndEditable --><!-- TemplateEndIf --> <img src="image/kongzi.gif" width="160" height="300" align="left" /></td>
      <td width="80" align="center" valign="top" background="image/petal.gif" bgcolor="#FFFFFF">
	  <img src="image/right1.jpg" width="81" height="36" hspace="0" vspace="0" border="0" align="top" />
	  <p>&nbsp;</p>
	  <p><a href="index.jsp"><img src="image/tuichu.gif" width="77" height="33" border="0" /></a></p>
	  <p><a href="register.jsp"><img src="image/zhuce.gif" width="77" height="33" border="0" /></a></p>
	  </td>
    </tr>
    <tr>
      <td align="center" valign="bottom" background="image/petal.gif" bgcolor="#FFFFFF">
      <img src="image/right2.jpg" width="81" height="245" align="absbottom" /></td>
    </tr>
    
    <tr>
      <td height="12" colspan="4" background="image/background_up.jpg" bgcolor="#FFFFFF"><div align="center" class="STYLE3">(C) COPYRIGHT 2017 Wind（谢玉伸）</div></td>
    </tr>
  </table>
</form>
</body>
</html>
