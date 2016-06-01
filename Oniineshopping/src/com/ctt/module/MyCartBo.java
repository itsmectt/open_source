//用于处理与购物相关的业务逻辑
package com.ctt.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javassist.bytecode.Descriptor.Iterator;

public class MyCartBo {
//定义一个hashmap
	HashMap<String, String> hMap=new HashMap<String, String>();
	//定义喝数据库连接的相关变量
	private Connection ct=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	
	//1.添加货物
	public void addGoods(String goodsId, String goodsNum){
		hMap.put(goodsId, goodsNum);
	}
	//2.删除货物
	public void delGoods(String goodsId){
		hMap.remove(goodsId);
		
	}
	//3.修改货物数量
	public void UpdateGoods(String goodsId,String newGoodsNum) {
		hMap.put(goodsId, newGoodsNum);				//如果已存在goodsid就覆盖掉原来的那个ID重新写一遍num达到了修改num的目的
	}
	//4.清空货物
	public void clearGoods(){
		hMap.clear();
	}
	
	
	//5.显示购物车
	public ArrayList Showmycart() {
		
		ArrayList<GoodsBean> cartList=new ArrayList<GoodsBean>();
		try {
			String sql="select * from goods where goodsId in";
			Iterator iterator=(Iterator)hMap.keySet().iterator();
			String sub="(";
			while (iterator.hasNext()) {
				//取出goodsID
				String goodsId=(String)iterator.next();
				if (iterator.hasNext()) {
					sub+=goodsId+",";
				}else{
					sub+=goodsId+")";
				}					
			}
			      sql+=sub;
			      
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				GoodsBean gb=new GoodsBean();
				//放入到gb
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsname(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsprice(rs.getFloat(4));
				gb.setGoodsnum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				cartList.add(gb);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return cartList;
	}
	public void close() {
		try {
			
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (ct!=null) {
				ct.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
