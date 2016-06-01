package com.ctt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctt.module.MyCartBo;

public class ShowCartCl extends HttpServlet {
	     

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
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
				//删除购物车商品信息
		String type=request.getParameter("type");
		
		//使用session保证始终只有一个购物车
		MyCartBo mbo=(MyCartBo)request.getSession().getAttribute("mycart");
		if (mbo==null) {
			mbo=new MyCartBo();
			request.getSession().setAttribute("mycart", mbo);		       
		}
		if (type.equals("addGoods")) {
					
		//获取ID
		String goodsId=request.getParameter("goodsId");
		
		//调用bo
		//    MyCartBo mbo=new MyCartBo();
		
		
		mbo.addGoods(goodsId, "1");
		
		}else if (type.equals("delGoods")) {
			String  goodsId=request.getParameter("goodsId");
			mbo.delGoods(goodsId);
		}else if (type.equals("show")) {
			//森么都不做，自然等待进行下一步的页面跳转
		}else if (type.equals("delAll")) {
			mbo.clearGoods();
			
		}
		//取出购物车信息
		 ArrayList al=mbo.Showmycart();
		 request.setAttribute("mycartInfo", al);
		 
		
		 
		//返回显示页面
		request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
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

		this.doGet(request, response);
	}

}
