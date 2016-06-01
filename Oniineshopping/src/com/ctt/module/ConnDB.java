//得到一个数据库连接

package com.ctt.module;

import java.sql.Connection;
import java.sql.DriverManager;




public class ConnDB {
    private Connection ct=null;
    public Connection getConn() throws Exception{
    	Class.forName("com.mysql.jdbc.Driver");
    	try {
    		
     ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlineshopping","root","");
           	
    	} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	return ct;
    }
}
