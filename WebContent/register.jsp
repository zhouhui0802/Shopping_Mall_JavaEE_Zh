<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/my.css">
<title>Insert title here</title>
</head>
  <body topmargin="0" background="images/myBack.jpg" >
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="33" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="68" align="center">
    <table width="50%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#339900" class="com">
  <tr>
    <td height="25" colspan="2" align="center" bgcolor="#FFFF66">用户登录</td>
  </tr>
  <tr>
    <td width="36%" height="29" align="right">用户名:</td>
    <td width="64%" align="center"><input type="text" name="textfield" /></td>
  </tr>
  <tr>
    <td height="28" align="right">密&nbsp;&nbsp;码:</td>
    <td align="center"><input type="text" name="textfield2" /></td>
  </tr>
  <tr>
    <td height="34" colspan="2" align="center"><input name="Submit" type="submit" value="登 录" />
       &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" name="Submit2" value="注 册" /></td>
  </tr>
</table>
    </td>
  </tr>
  <tr>
    <td height="46" align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>