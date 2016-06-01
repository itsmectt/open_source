package com.ctt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctt.module.MyCartBo;
import com.ctt.module.UserBean;
import com.ctt.module.UserBeanBo;

public class LoginCl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//获取登录信息
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		
		
		//验证用户
		UserBeanBo ubBo=new UserBeanBo();
		if (ubBo.checkUser(u, p)){
			//将成功登录的用户信息放入session，以后有用
			UserBean ub=ubBo.getUserBean(u);
			request.getSession().setAttribute("userinfo",ub);
			
			//从购物车中取出信息
			MyCartBo mcb=(MyCartBo)request.getSession().getAttribute("mycart");
			ArrayList al=mcb.Showmycart();
			request.setAttribute("mycartInfo", al);
			//用户合法
			request.getRequestDispatcher("orderform.jsp").forward(request, response);
		}else {		
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         this.doGet(request,response);
	}

}
