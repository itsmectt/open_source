<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	
  </head>
  
  <body topmargin="0" background="images/13.jpeg">
     <table width="80%" height="445" border="1" align="center">
  <tr>
    <td height="135" colspan="2" style="background-color:#DF4239">&nbsp;
    <!-- 引入jsp -->
    <jsp:include page="Head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="24%" height="252">
    <jsp:include page="Left.jsp"></jsp:include></td>
    <td width="76%" valign="top">
    <jsp:include page="Right.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;
    <jsp:include page="Tail.jsp"></jsp:include></td>
  </tr>
</table>
  </body>
</html>
