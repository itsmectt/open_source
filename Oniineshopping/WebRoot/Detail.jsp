<%@page import="com.ctt.module.GoodsBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//取出要显示的信息（goodsbean）
GoodsBean gb=(GoodsBean)request.getAttribute("goodsInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function returnHall(){
	//添加_self即可在原页面上直接跳转
	    window.open("index.jsp","_self");
	}
	
	
	//响应购买按钮的事件
	function buy(goodsId){
	//向showcartcl这个servlet发出请求，并把ID传过去
	//window.alert(goodsId);
	   window.open("ShowCartCl?type=addGoods&goodsId="+goodsId,"_self");
	}
	</script>
  </head>
  
  <body topmargin="0" background="images/13.jpeg">
<table width="80%" border="1" align="center">
  <tr>
    <td align="center">
    <jsp:include page="Head.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td><table width="100%" border="1">
      <tr>
        <td width="35%" rowspan="4"><img src="images/<%=((GoodsBean)request.getAttribute("goodsInfo")).getPhoto() %>" width="225" height="226"  alt=""/></td>
        <td height="30" align="center"><%=((GoodsBean)request.getAttribute("goodsInfo")).getGoodsname() %></td>
      </tr>
      <tr>
        <td height="40" align="center">价格：<%=((GoodsBean)request.getAttribute("goodsInfo")).getGoodsprice() %> &nbsp;&nbsp;&nbsp;&nbsp;ISBN:<%=gb.getGoodsId() %></td>
      </tr>
      <tr>
        <td height="49">类型：<%=((GoodsBean)request.getAttribute("goodsInfo")).getType() %>&nbsp;&nbsp;出版商：<%=((GoodsBean)request.getAttribute("goodsInfo")).getPublisher() %></td>
      </tr>
      <tr>
        <td align="center"><input type="button" onclick="buy(<%=gb.getGoodsId()%>);" style="width:30%; height:30px;" value="立即购买">
        &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" style="width:30%; height:30px;" value="返回购物大厅" onclick="returnHall();"></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include page="Tail.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>
