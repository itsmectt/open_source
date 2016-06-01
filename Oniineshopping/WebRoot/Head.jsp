<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

      <link rel="stylesheet" type="text/css" href="my.css">
<table width="100%" border="0" align="center">
  <tr>
    <td width="18%" height="135"><img src="images/06.png" width="215" height="138"  alt=""/></td>
    <td width="51%" align="center" bgcolor="#DF4239" class="font">  <h1>购物网站</h1></td>
    <td width="31%" bgcolor="#DF4239"><p><img src="images/09.png" width="39" height="39"  alt=""/><a href="Login.jsp">[我的账号]</a><br>
    <img src="images/10.png" width="39" height="44"  alt=""/><a href="ShowCartCl?type=show">[我的购物车]</a></p></td>
  </tr>
  <tr>
    <td colspan="3"><table width="100%" border="0">
      <tr>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">首页</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">衣服</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">鞋子</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">女包</td>
        <td width="6%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

