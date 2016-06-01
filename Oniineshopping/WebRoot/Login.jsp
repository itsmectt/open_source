<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0" background="images/13.jpeg">
  <%request.setCharacterEncoding("utf-8"); %>
  
<table width="80%" border="1" align="center">
  <tr>
    <td><jsp:include page="Head.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td>
    <form action="/LoginCl" method="post">
    <table width="60%" height="145px" border="1" align="center">
      <tr>
        <td colspan="2" align="center" bgcolor="#990033" class="font">Log in</td>
        </tr>
      <tr>
        <td width="38%" align="center">username:</td>
        <td width="62%" align="center"><input type="text" name="username"></td>
      </tr>
      <tr>
        <td align="center">password:</td>
        <td align="center"><input type="password" name="password" ></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input name="button" type="submit" id="submit" value="login">
        &nbsp;&nbsp;&nbsp;
          <input name="button2" type="button" id="button2" value="register"></td>
        </tr>
    </table>
    </form></td>
  </tr>
  <tr>
    <td><jsp:include page="Tail.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>
