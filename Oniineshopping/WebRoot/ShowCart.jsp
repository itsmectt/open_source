<%@page import="com.ctt.module.GoodsBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      ArrayList al=(ArrayList)request.getAttribute("mycartInfo");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<script type="text/javascript">
	function delAll(){
	window.open("ShowCartCl?type=delAll","_self");
	}
	</script>

  </head>
  
  <body topmargin="0" background="images/13.jpeg">
  <%request.setCharacterEncoding("utf-8"); %>
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
        <td width="11%" align="center">编号</td>
        <td width="30%" align="center">名称</td>
        <td width="33%" align="center">单价</td>
        <td colspan="3" align="center">数量</td>
      </tr>     
      
      <% 
      
      for(int i=0;i<al.size();i++){
      GoodsBean gb=(GoodsBean)al.get(i);
      %>
      <tr>
        <td align="center"><%=gb.getGoodsId() %></td>
        <td align="center"><%=gb.getGoodsname() %></td>
        <td align="center"><%=gb.getGoodsprice() %></td>
        <td width="8%" align="center"><input name="textfield" type="text" id="textfield" size="7" maxlength="7"></td>
        <td width="9%" align="center"><a href="ShowCartCl?type=delGoods&goodsId=<%=gb.getGoodsId() %>">删除</a></td>
        <td width="9%" align="center"><a href="ShowGoodsCl?type=Detail&goodsId=<%=gb.getGoodsId() %>">查看</a></td>
        <% }%>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
        <td align="center"><input type="submit" name="submit" id="submit" onclick="delAll();" value="清空购物车"></td>
        <td align="center"><input type="button" name="button" id="button" value="修改数量"></td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="6">&nbsp;</td>
        </tr>
      <tr>
        <td colspan="6"><table width="100%" border="0">
          <tr>
            <td width="50%">需付款：100.0元 点此处<a href="">继续购物</a></td>
            <td width="50%" align="right"><a href="Logintiaozhuan"><img src="images/Botton.jpg" width="102" height="33"  alt=""/></a></td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><jsp:include page="Tail.jsp"></jsp:include></td>
  </tr>
 </table>
  </body>
</html>
