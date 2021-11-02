package com.zh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.model.*;
import com.zh.model.UserBean;
import com.zh.model.UserBeanBo;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		//�����û���������
		String u=MyTools.changeToGB2312(request.getParameter("textfield"));
		String p=request.getParameter("textfield2");
		System.out.println("u="+u+" p="+p);
		
		
		
		
		
		UserBeanBo ubb=new UserBeanBo();
		
		if(ubb.checkUser(u, p)){
			//����һ��userbean,�����뵽session
			UserBean ub=ubb.getUserBean(u);			
			request.getSession().setAttribute("loginUserinfo", ub);
			//��Ҫ��ʾ�Ĺ��ﳵ��Ʒ���ݷ���request
			MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
			
			request.setAttribute("mycartInfo", mc.showAllMyCart());
			System.out.println("�û���¼�����ﳵ���ɹ�");
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}else{
			
			//����ҳ��
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
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
