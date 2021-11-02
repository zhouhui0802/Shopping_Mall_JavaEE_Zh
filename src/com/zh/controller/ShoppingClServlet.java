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
		//�õ�bookId,��Ҫ����Ļ�����ӵ����ﳵ
		
		String goodsId=request.getParameter("goodsIdSp");
		System.out.println("������ʾ��Ϣ���鱾�ı��goodsId="+goodsId);
		
		//��session��ȡ������
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		
		if(mc==null){
			
			//˵��û�е�¼��,��ʱ�Ϳ��Դ���һ�����ﳵ��������session
			mc=new MyCart();
			request.getSession().setAttribute("mycart", mc);
		}
		
		//���ﳵ�����ѡ�еĻ���
		mc.addGoods(goodsId, "1");
		
		//ȡ�����׼����ʾ
		request.setAttribute("mycartGoods", mc.showAllMyCart());
		
		request.getRequestDispatcher("cartInfo.jsp").forward(request, response);
		System.out.println("���ﳵ����ӳɹ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
