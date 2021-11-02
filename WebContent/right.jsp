<%@ page language="java" import="java.util.*,com.zh.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	
%>

<%
	//调用Bo,得到数据
	GoodsBeanBo gbb = new GoodsBeanBo();
	String pageNow=(String)request.getAttribute("now");
	System.out.println("right.jsp中的pageNow="+pageNow);
	int n_pageNow=1;
	if(pageNow!=null){
		
		n_pageNow=Integer.parseInt(pageNow);
	}
	
	//默认的显示第一页
	ArrayList al = gbb.showGoodsByPage(6, n_pageNow);
	System.out.println("al.size="+al.size());
%>


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="com">
	<tr>
		<td colspan="3" align="left">
			<img src="images/booksTop.gif" width="436" height="63" />
		</td>
	</tr>
	<%
			int k=0;
			for (int i = 0; i < 2; i++) {
	%>
	<tr>
		<%
					for (int j = 0; j < 3; j++) {
					GoodsBean gb=new GoodsBean();
					if(k<al.size()){
						gb = (GoodsBean) al.get(k);
					}else{
						
						gb.setGoodsId(0);
						gb.setGoodsName("没有该书");
						gb.setGoodsIntro("没有了");
						gb.setPhoto("none.jpg");
						gb.setGoodsPrice(0.0f);
					}
		%>
		<td width="33%" height="168" align="center">
			<table width="100%" height="168" border="0" cellpadding="0"
				cellspacing="0" class="com">
				<tr>
					<td width="112" height="112" rowspan="3">
						<img src="images/<%=gb.getPhoto()%>" width="112" height="112" />
					</td>
					<td width="130" height="48">

					</td>
				</tr>
				<tr>
					<td height="33" valign="top">
					<!-- 在讲解的时候，先做出showDetail.jsp的静态页面，直接跳转，然后提出问题，使用servlet去准备数据 -->
					<!-- <a href="showDetail.jsp"><%=gb.getGoodsName()%></a> -->
					<a href="ShowGoodsClServlet?type=showDetail&goodsId=<%=gb.getGoodsId() %>"><%=gb.getGoodsName()%></a>	
					</td>
				</tr>
				<tr>
					<td height="22" valign="top">
						价格:
						<%=gb.getGoodsPrice()%>
						$
					</td>
				</tr>
				<tr>
					<td colspan="2" valign="top">
						简单介绍：
						<%=gb.getGoodsIntro()%>
					</td>
				</tr>
			</table>
		</td>
		<%
		k++;
		}
		%>

	</tr>


	<%
	if (i == 0) {
	%>
	<tr>
		<td height="10" bgcolor="pink" colspan="3" align="center"></td>
	</tr>
	<%
	}
	}
	%>

	<tr>
		<td colspan="3" align="center">
			<%
					int pageCount =gbb.getPageCount();
					
					for(int i=1;i<=pageCount;i++){
						
						%>
						<a href="ShowGoodsClServlet?type=fenye&pageNow=<%=i %>">[<%=i %>]</a>
						<%
					}
			
			 %>
		</td>
	</tr>
</table>
