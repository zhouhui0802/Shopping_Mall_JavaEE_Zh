package com.zh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.model.GoodsBeanBo;

/**
 * Servlet implementation class ShowGoodsClServlet
 */
@WebServlet("/ShowGoodsClServlet")
public class ShowGoodsClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收type类型 从right.jsp中传过来的数据
		String type=request.getParameter("type");
		
		if(type.equals("fenye")){
			
			//接受pageNow,放入request
			String pageNow=request.getParameter("pageNow");
			
			System.out.println("ShowGoodsClServlet中的pageNow==="+pageNow);
			request.setAttribute("now",pageNow );
			System.out.println("将pageNow传给now");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else if(type.equals("showDetail")){
			
			System.out.println("显示货物的具体信息");
			
			//接收货物的id
			String bookId=request.getParameter("goodsId");
			
			//创建一个GoodsBeanBo,去查询具体的
			GoodsBeanBo gbb=new GoodsBeanBo();
			
			request.setAttribute("goodsInfo", gbb.getGoodsBeanById(bookId));
			
			request.getRequestDispatcher("showDetail.jsp").forward(request, response);
			
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
