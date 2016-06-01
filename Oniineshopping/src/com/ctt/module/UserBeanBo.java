package com.ctt.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class UserBeanBo {
	//database again
	ResultSet rs=null;
	Connection ct=null;
	PreparedStatement ps=null;
	
	/**
	 * 根据用户名返回用户的全部信息
	 * @param username
	 * @param password
	 * @return userbean
	 */
	public UserBean getUserBean(String username){
		UserBean ub=new UserBean();
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select * from users1 where username= ? ");
			ps.setString(1,username);
			rs=ps.executeQuery();
			if (rs.next()) {
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setPhone(rs.getLong(5));
				ub.setAddr(rs.getString(6));
				ub.setGrade(rs.getInt(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return ub;
	}
	
	
	public boolean checkUser(String username,String password) {
		boolean b=false;
		try {
			ct=new ConnDB().getConn();			
			ps=ct.prepareStatement("select passwd from users1 where username = ? ");
			ps.setString(1,username);
			rs=ps.executeQuery();
			if (rs.next()) {
				String dbpasswd=rs.getString(1);
				if (dbpasswd.equals(password)) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		return b;
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
