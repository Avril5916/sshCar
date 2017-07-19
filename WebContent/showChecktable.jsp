<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div style="border: 1px solid blue; width: 100%; height: 10%; background-color: lavender;" align="center">
  		<h3>查询用户显示列表</h3>
  		
  		 	<table border="1px" width="980px" style="margin-top: 5px">
  		 	<tr style="background-color: aqua;">
  		 		
  				
  				<th>检查单号</th>
  				<th>检查时间</th>
  				<th>属性</th>
  				<th>问题</th>
  				<th>赔费</th>
  				<th>检查员</th>
  				<th>出租单号</th>
  				<th>操作</th>
  				
  			</tr>
  			<c:forEach items="${page.list}" var="checktable">
	  			<tr align="center">
	  				<td>${checktable.checkid }</td>
	  				<td>${checktable.checkdate }</td>
	  				<td>${checktable.field }</td>
	  				<td>${checktable.problem}</td>
	  				<td>${checktable.paying }</td>
	  				<td>${checktable.user.username}</td>
	  				<td>${checktable.renttable.tableid}</td>
	  				
	  				<td><a href="preUpdateChecktable.action?tableid=${checktable.checkid }">修改</a>|
	  					<a href="delChecktable.action?tableid=${checktable.checkid }">删除</a></td>
	  			</tr>
  			</c:forEach>	
  				<tr>
  					<td align="center">
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
  		
       </div>
		<form action="findChecktable.action" method="post" id="form2">
			<%-- <input type="hidden" name="page.class" value="${page }"> --%>
			
			<input type="hidden"  name="checktable.checkid" value="${checktable.checkid }">
			<input type="hidden"  name="checktable.field" value="${checktable.field }">
			<input type="hidden"  name=checktable.problem value="${checktable.problem}">
			<input type="hidden" id="cp" name="currentPage" value="${page.currentPage }">
		</form>

</body>
</html>