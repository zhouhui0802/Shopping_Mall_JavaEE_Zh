package com.zh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.model.MyCart;

/**
 * Servlet implementation class ShoppingClServlet
 */
@WebServlet("/ShoppingClServlet")
public class ShoppingClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到bookId,将要购买的货物添加到购物车
		
		String goodsId=request.getParameter("goodsIdSp");
		System.out.println("接收显示信息中书本的编号goodsId="+goodsId);
		
		//从session中取出购物
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		
		if(mc==null){
			
			//说明没有登录过,这时就可以创建一个购物车，并放入session
			mc=new MyCart();
			request.getSession().setAttribute("mycart", mc);
		}
		
		//向购物车中添加选中的货物
		mc.addGoods(goodsId, "1");
		
		//取出货物，准备显示
		request.setAttribute("mycartGoods", mc.showAllMyCart());
		
		request.getRequestDispatcher("cartInfo.jsp").forward(request, response);
		System.out.println("购物车中添加成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
