<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
String path = request.getContextPath();
System.out.println("代码中的开头path="+path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("代码中的开头basePath="+path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<table width="100%" class="comm" border="0" cellpadding="0">
  <tr>
    <td align="center" bgcolor="#FFCCCC">合作伙伴:    <a href="http://www.sohu.com">搜狐</a>    <a href="http://www.163.com">网易</a>   百度    新浪 </td>
  </tr>
  <tr>
    <td align="center">地址：北京市崇文区 客户服务热线直拨：010-0000000</td>
  </tr>
  <tr>
    <td align="center">邮编：100000 客服信箱：shawn@sina.com</td>
  </tr>
  <tr>
    <td align="center">Copyright 时尚购物网 </td>
  </tr>
</table>