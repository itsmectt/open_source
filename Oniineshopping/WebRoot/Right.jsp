<%@page import="com.ctt.module.GoodsBean"%>
<%@page import="com.ctt.module.GoodsBeanBo"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

GoodsBeanBo gbo=new GoodsBeanBo();
String s_pageNow=(String)request.getAttribute("fy");
int pageNow=1;
if(s_pageNow!=null){
	pageNow=Integer.parseInt(s_pageNow);
}
    ArrayList al=gbo.getGoodsByPage(6,pageNow);
    
    //得到总共多少页
   int pageCount=new GoodsBeanBo().getPageCount(6);
%>

<table width="100%" border="0">
<%
        int time=0;
        for(int i=0;i<2;i++){
        %><tr><%
        for(int j=0;j<3;j++){
        if(time<al.size()){
        	GoodsBean gb=(GoodsBean)al.get(time);
        	time++;
        	
        
        	%>
       
       <td width="33%"> 
        
        <table width="99%" border="1">
          <tr>
            <td width="23%" rowspan="3"><img src="images/<%=gb.getPhoto() %>" width="225" height="226"  alt=""/></td>
            <td width="77%">&nbsp;</td>
          </tr>
          <tr>
            <td><a href="ShowGoodsCl?type=Detail&id=<%=gb.getGoodsId() %>"><%=gb.getGoodsname() %></a></td>
          </tr>
          <tr>
            <td>简介：棉麻衬衫</td>
          </tr>
          <tr>
            <td colspan="2" align="center">价格：<%=gb.getGoodsprice() %></td>
            </tr>
        </table></td>
        	<%
        	}
        	}
        	%></tr>

      <% if(i==0){
	          %><tr>
          <td colspan="3" bgcolor="#990000" align="center">&nbsp;</td>
          </tr><%
}
        	
        }
              
         %>
  
  <tr>
    <td colspan="3" align="center" class="navi font" bgcolor="#990000">
    <%
    for(int i=1;i<=pageCount;i++){
    %>
    <a href="ShowGoodsCl?type=fenye&pageNow=<%=i%>">[<%=i%>]</a>
    <%
                 }
     %>
    </td>
  </tr>
</table>
