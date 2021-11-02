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
		//����type���� ��right.jsp�д�����������
		String type=request.getParameter("type");
		
		if(type.equals("fenye")){
			
			//����pageNow,����request
			String pageNow=request.getParameter("pageNow");
			
			System.out.println("ShowGoodsClServlet�е�pageNow==="+pageNow);
			request.setAttribute("now",pageNow );
			System.out.println("��pageNow����now");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else if(type.equals("showDetail")){
			
			System.out.println("��ʾ����ľ�����Ϣ");
			
			//���ջ����id
			String bookId=request.getParameter("goodsId");
			
			//����һ��GoodsBeanBo,ȥ��ѯ�����
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
