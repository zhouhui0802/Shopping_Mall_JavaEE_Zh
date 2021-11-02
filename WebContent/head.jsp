<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="8" colspan="3" bgcolor="#FFCCCC"></td>
        </tr>
      <tr>
        <td width="24%" height="78"><img src="images/logo.gif" width="128" height="49" /></td>
        <td width="53%" align="center"><img src="images/test.gif" width="450" height="80" /></td>
        
        <td width="23%" align="center" class="com"><p><img src="images/account.gif" width="19" height="14" /><a href="shopping2.jsp">【我的账号】</a></p>
          <p><img src="images/cart.gif" width="20" height="15" /><a href="Tips.jsp">【我的购物】</a></p></td>
      </tr>
      <tr>
        <td height="8" colspan="3" bgcolor="#FFCCCC"></td>
        </tr>
      <tr>
        <td colspan="3"><table width="100%" border="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td width="15%" class="navi"><a href="index.jsp">首页</a></td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">香港电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">大陆电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">关于我们</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        </tr>
    </table>