<%@page import="com.avril.domain.Menus"%>
<%@page import="com.avril.domain.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <SCRIPT language=javascript src="js/dtree/dtree.js"></SCRIPT>
    <script type="text/javascript" src="js/java-like.util.js"></script>
    <link rel="stylesheet" href="js/dtree/dtree.css" type="text/css">
    </head>
  
  <body>
		<table width="100%">
		<c:forEach items="${session.menus }" var="menu">
		<c:choose >	
		
			<c:when test="${menu.fatherid == 1 }">		
				<tr  align="center">
					<td width="100%">
							<div style="background-image:url('images/small/sec-topic.gif');background-repeat: no-repeat;background-position: center;"><b>${menu.name }</b></div>
					</td>
				</tr>
			</c:when>
			
			<c:when test="${menu.fatherid > 1 }">		
				<tr  >
					<td >
							<div style="margin-left: 15px ;font-size: 15"><img src="images/small/mark.gif" width="7px" height="7px">
							<a href="${menu.uri }" target="main" style="text-decoration:none; cursor: pointer; color: gray;">${menu.name }</a></div>
					</td>
				</tr>
			</c:when>
			
			 <%-- <c:otherwise>		
				 <tr  align="center">
					<td>
							<div style="font-size: 25;">
							<b>${menu.name }</b></div>
					</td>
				</tr>
			</c:otherwise>	 --%>
		</c:choose> 
		</c:forEach>
		</table>
 
  </body>
</html>
