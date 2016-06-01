<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Tail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">


  </head>
  
  <body>
    <table width="100%" border="0" align="center" >
  <tr>
    <td align="center" bgcolor="#990000" class="font">合作伙伴：<a href="">搜狐</a> <a href="">网易</a> 百度  新浪</td>
  </tr>
  <tr>
    <td align="center">地址：武汉理工大学 客户服务热线：000102020</td>
  </tr>
  <tr>
    <td align="center" bgcolor="#990000" class="font">邮编：009090 邮箱地址：8wbxwxb@123.com</td>
  </tr>
  <tr>
    <td align="center">Copyright 购物网</td>
  </tr>
</table>
  </body>
</html>
