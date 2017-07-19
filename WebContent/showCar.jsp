<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function frontPage() {
		document.getElementById("cp").value=document.getElementById("cp").value*1-1;
		document.getElementById("form2").submit();
	}
	
	function afterPage() {
		document.getElementById("cp").value=document.getElementById("cp").value*1+1;
		document.getElementById("form2").submit();
	}
</script>
</head>
<body>
<div style="background-color: #2E4D75;"><h1><font color="white">汽车信息展示页面</font></h1></div>
<table border="1px" cellspacing="0px" align="center" width="1000px" style="color: blue;">
<tr>
<td bgcolor="#2E4D75"><font color="white">车号</font></td>
<td bgcolor="#2E4D75"><font color="white">颜色</font></td>
<td bgcolor="#2E4D75"><font color="white">型号</font></td>
<td bgcolor="#2E4D75"><font color="white">价格</font></td>
<td bgcolor="#2E4D75"><font color="white">租金</font></td>
<td bgcolor="#2E4D75"><font color="white">押金</font></td>
<td bgcolor="#2E4D75"><font color="white">租用情况</font></td>
<td bgcolor="#2E4D75"><font color="white">编辑</font></td>
<td bgcolor="#2E4D75"><font color="white">删除</font></td>
</tr>
<c:forEach items="${page.list}" var="car">
<tr>
<td>${car.carnumber}</td>
<td>${car.color}</td>
<td>${car.cartype}</td>
<td>${car.price}</td>
<td>${car.rentprice}</td>
<td>${car.deposit}</td>
<td>${car.isrenting}</td>
<td><a href="preUpdateCar.action?carnumber=${car.carnumber }">编辑</a></td>
<td><a href="delCar.action?carnumber=${car.carnumber }">删除</a></td>
</tr>
</c:forEach>
<tr>
	<td colspan="10" align="center">
		<c:choose>
			<c:when test="${page.currentPage>1*1 }">
				<a onclick="frontPage()" style="cursor: pointer;color: blue" >上一页</a>
			</c:when>
			<c:otherwise>
				<a>上一页</a>
			</c:otherwise>
		</c:choose>
	 	第${page.currentPage}页/共${page.totalPage }页 
	 	<c:choose>
			<c:when test="${page.currentPage<page.totalPage }">
				<a onclick="afterPage()" style="cursor: pointer;color: blue" >下一页</a>
			</c:when>
			<c:otherwise>
				<a>下一页</a>
			</c:otherwise>
		</c:choose>
	</td>
</tr>


</table>
<form action="findCar.action" method="post" id="form2">
			<%-- <input type="hidden" name="page.class" value="${page }"> --%>
			
			<input type="hidden"  name="car.carnumber" value="${car.carnumber }">
			<input type="hidden"  name="car.cartype" value="${car.cartype }">
			<input type="hidden" id="cp" name="currentPage" value="${page.currentPage }">
		</form>
</body>
</html>