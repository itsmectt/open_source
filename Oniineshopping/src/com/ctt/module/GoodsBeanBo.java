package com.ctt.module;


import java.sql.*;
import java.util.ArrayList;

public class GoodsBeanBo {
	ResultSet rs=null;
	Connection ct=null;
	PreparedStatement ps=null;
	
	
	/**
	 * 返回共有多少页
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public int getPageCount(int pageSize){
		int pageCount=0;
		int rowCount=0; //一页有多少条数据
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select count(*) from goods");
			rs=ps.executeQuery();
			if (rs.next()) {
				 rowCount=rs.getInt(1);	//返回下标值为1的整数值也就是count数
			}
			if (rowCount%pageSize==0) {
				pageCount=rowCount/pageSize;
			}else {
				pageCount=rowCount/pageSize+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		 return pageCount;
	}
	
	
	
	
	
	
	//分页显示商品信息
	public ArrayList getGoodsByPage(int pageSize,int pageNow) {
		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from goods where goodsId limit " +((pageNow-1)*pageSize)+","+pageSize);
		
			rs=ps.executeQuery();
			while(rs.next()) {
				//把查询到的接过集封装到goodsbean里面
				GoodsBean gb1=new GoodsBean();
				gb1.setGoodsId(rs.getInt(1));
				
				gb1.setGoodsId(rs.getInt(1));
				gb1.setGoodsname(rs.getString(2));
				gb1.setGoodsIntro(rs.getString(3));
				gb1.setGoodsprice(rs.getFloat(4));
				gb1.setGoodsnum(rs.getInt(5));
				gb1.setPublisher(rs.getString(6));
				gb1.setPhoto(rs.getString(7));
				gb1.setType(rs.getString(8));
				
				//把gb的内容添加到arraylist里面去
				al.add(gb1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return al;
	}
	
	
	
	
	//根据货物的ID来获取货物的信息
	public GoodsBean getGoodsBean(String id){
		GoodsBean gb=new GoodsBean();
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				//放入到gb
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsname(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsprice(rs.getFloat(4));
				gb.setGoodsnum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			//调用关闭函数释放资源
			this.close();
		}
		return gb;
	}
	public void close(){
		try {
			if (rs!=null) {
				rs.close();
				rs=null;
			}
			if (ps!=null) {
				ps.close();
				ps=null;
			}
			
			if (ct!=null) {
				ct.close();
				ct=null;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}

