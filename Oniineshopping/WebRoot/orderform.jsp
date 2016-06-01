<%@page import="com.ctt.module.GoodsBean"%>
<%@page import="com.ctt.module.UserBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到用户的信息
UserBean ub=(UserBean)session.getAttribute("userinfo");
//购物车的信息
ArrayList al=(ArrayList)request.getAttribute("mycartinfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body topmargin="0" background="images/13.jpeg">
  <%request.setCharacterEncoding("utf-8");%>
  	<table width="80%" border="1" align="center">
  <tr>
    <td><jsp:include page="Head.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td><table width="100%" border="1">
      <tr>
        <td colspan="6"><img src="images/gouwuche.jpg" width="899" height="53"  alt=""/></td>
  </tr>
  <tr>
    <td align="center"><table width="70%" border="1">
      <tr>
        <td colspan="2" align="center">购买人信息</td>
        </tr>
      <tr>
        <td width="50%" align="right">用户名：</td>
        <td width="50%"> <input type="text" id="name" value="<%=ub.getUsername()%>"/></td>
      </tr>
      <tr>
        <td align="right">家庭住址：</td>
        <td><input type="text"  id="textfield2" value="<%=ub.getAddr()%>"/></td>
      </tr>
      <tr>
        <td align="right">联系电话：</td>
        <td><input type="text" name="textfield3" id="textfield3" value=" <%= ub.getPhone()%>"/></td>
      </tr>
      <tr>
        <td align="right">电子邮箱：</td>
        <td><input type="text" name="textfield4" id="textfield4" value="<%=ub.getEmail()%>"/></td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right"><input type="button" name="button" id="button" value="完成订单"></td>
        <td><input type="button" name="button2" id="button2" value="修改个人信息"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center"><table width="70%" border="1">
      <tr>
        <td colspan="4" align="center">我的购物车情况</td>
        </tr>
      <tr>
        <td width="30%" align="center">编号</td>
        <td width="19%" align="center">商品名称</td>
        <td width="26%" align="center">单价</td>
        <td width="25%" align="center">数量</td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4">您共选择了100元的商品</td>
        </tr>
      <tr>
        <td colspan="4" align="center"><input type="button" name="button3" id="button3" value="返回修改购物车"></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="right"><input type="button" name="button4" id="button4" value="上一步">
    <input type="button" name="button5" id="button5" value="下一步"></td>
  </tr>
  <tr>
    <td><jsp:include page="Tail.jsp"></jsp:include></td>
  </tr>
</table>
  </body>
  </html>

