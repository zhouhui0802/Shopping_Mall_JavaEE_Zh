<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/my.css">
</head>
  <body topmargin="0" background="images/myBack.jpg">
  <table width="80%" border="0" align="center"  cellpadding="0">
  <tr>
    <td height="68" colspan="2" align="center"><jsp:include flush="true" page="head.jsp" /></td>
  </tr>
  <tr>
    <td width="21%" height="" valign="top" align="center"><jsp:include flush="true" page="left.jsp" /></td>
    <td width="79%" height="" align="center" valign="top">
    <jsp:include flush="true" page="right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="45" colspan="2" align="center"><jsp:include flush="true" page="foot.jsp" /></td>
  </tr>
</table>
  </body>
</html>