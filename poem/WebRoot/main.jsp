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
<form id="form1" name="form1" method="post" action="poem_find">
  <table width="1006" height="900" border="0" align="center" bordercolor="#FFFFFF" background="image/petal.gif" bgcolor="#D9D3AF">
    <tr>
      <td width="336" height="59" align="center" background="image/background_up1.jpg">&nbsp;</td>
      <td width="336" align="center" background="image/background_up2.jpg"><span class="STYLE1">古诗词欣赏</span></td>
      <td width="230" align="center" background="image/background_up3.jpg">&nbsp;</td>
      <td height="59" align="center" background="image/background_up3.jpg"><span class="STYLE1"><img src="image/bainiao.gif" width="80" height="59" /></span></td>
    </tr>
	
    <tr>
      <td height="20" colspan="4" align="left" background="image/background_up3.jpg">
    <label></label>   
	    
      <input name="str_find" type="text" value="李白" size="20"/>
      <input name="find" type="submit"  value="搜索" /> 
    <tr>
      <td height="7" colspan="2" align="left"> 
	  <a href="poem_find?str_find=*1">秦汉</a> - 
	  <a href="poem_find?str_find=*2">隋唐</a> - 
	  <a href="poem_find?str_find=*3">宋代</a> - 
	  <a href="poem_find?str_find=*4">金元</a> - 
	  <a href="poem_find?str_find=*5">明清</a>	  </td>
    </tr>
      <td colspan="3" rowspan="2" align="left" valign="top" background="image/butterfly.gif" bgcolor="#F7F2DF"><!-- TemplateBeginIf cond="OptionalRegion1" --><!-- TemplateBeginEditable name="EditRegion3" -->
        <div align="center"><img src="image/background_main.jpg" width="910" height="130" align="top" />
		   <!------------------------------------------编辑区域 ------------------------------------------>
		   <%= request.getSession().getAttribute("main_str")%>  
              <p>&nbsp;</p>
              <p>&nbsp;                    </p>
        </div>
      <!-- TemplateEndEditable --><!-- TemplateEndIf --><img src="image/kongzi.gif" width="160" height="300" align="left" /></td>
      <td width="84" height="330" align="center" valign="top" background="image/petal.gif" bgcolor="#FFFFFF">
	  <img src="image/right1.jpg" width="81" height="36" hspace="0" vspace="0" border="0" align="top" />
	  <p><a href="index.jsp"><img src="image/tuichu.gif" width="77" height="33" border="0" /></a></p>
	  <p><a href="register.jsp"><img src="image/zhuce.gif" width="77" height="33" border="0" /></a></p>
	  <p><a href="user_show"><img src="image/gerenxinxi.gif" width="77" height="33" border="0" /></a></p>
	  <p><a href="user_history"><img src="image/lishijilu.gif" width="77" height="33" border="0" /></a></p>
	  <p><a href="user_collect"><img src="image/gerenshoucang.gif" width="77" height="33" border="0" /></a></p>
	  <p>&nbsp;</p></td>
    </tr>  <tr>
        <td height="443" align="center" valign="bottom" background="image/petal.gif" bgcolor="#FFFFFF">
        <img src="image/luoye.gif" width="84" height="200" />
        <img src="image/right2.jpg" width="81" height="220" align="absbottom" /></td>
      </tr>
    
    <tr>
      <td height="12" colspan="4" background="image/background_up.jpg" bgcolor="#FFFFFF"><div align="center" class="STYLE3">(C) COPYRIGHT 2017 Wind（谢玉伸）</div></td>
    </tr>
  </table>
</form>
</body>
</html>
