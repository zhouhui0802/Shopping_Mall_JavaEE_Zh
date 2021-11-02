package com.zh.controller;
import com.zh.model.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class OrderClServlet
 */
@WebServlet("/OrderClServlet")
public class OrderClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//������ɶ���(�Ѷ���д�����ݿ�)
		//�����񽫻ύ��OrderBeanBO
		
		OrderBeanBO obb=new OrderBeanBO();
		System.out.println("��������߼�����");
		
		//�õ����ﳵ
		MyCart mcb=(MyCart)request.getSession().getAttribute("mycart");
		if(mcb==null)
		{
			System.out.println("����Ĺ��ﳵΪ��");
		}
		//�û�id
		long userId=((UserBean)request.getSession().getAttribute("loginUserinfo")).getUserid();
		System.out.println("OrderClServlet�е�userId="+userId);
		
		OrderInfoBean oib=obb.addOrder(mcb, userId+"");
		if(oib!=null){
			
			//���ok
			//׼����ʾ��������ϸ��Ϣ������,���¸�ҳ��shopping4.jsp
			
			request.setAttribute("detailbean", oib);
			request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		}else{
			//��Ӷ���ʧ��
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
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
