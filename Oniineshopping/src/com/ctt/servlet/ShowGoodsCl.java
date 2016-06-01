package com.ctt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;

import com.ctt.module.GoodsBean;
import com.ctt.module.GoodsBeanBo;

/**
 * Servlet implementation class ShowGoodsCl
 */
@WebServlet("/ShowGoodsCl")
public class ShowGoodsCl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsCl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		if (type.equals("Detail")) {
			
		
		// 获取要显示的商品的ID
		String goodsId=request.getParameter("id");
		//调用bo
		GoodsBeanBo gBo=new GoodsBeanBo();
		GoodsBean gb=gBo.getGoodsBean(goodsId);
		//request
		request.setAttribute("goodsInfo", gb);		
		
		//跳转		
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
		}else if (type.equals("fenye")) {
			String pageNow=request.getParameter("pageNow");
			
			request.setAttribute("fy", pageNow);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		// TODO Auto-generated method stub
	}

}
