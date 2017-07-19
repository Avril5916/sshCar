<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  		 		
  				
  				<th>登录名</th>
  				<th>身份证</th>
  				<th>性名</th>
  				<th>性别</th>
  				<th>职位</th>
  				<th>用户类型</th>
  				<th>编辑</th>
  				
  			</tr>
  			<c:forEach items="${page.list}" var="user">
	  			<tr align="center">
	  				<td>${user.username }</td>
	  				<td>${user.identity }</td>
	  				<td>${user.username }</td>
	  				<td>${user.sex}</td>
	  				<td>${user.position }</td>
	  				<td>${user.role.rolename}</td>
	  				
	  				<td><a href="preUpdateUser.action?username=${user.username }">修改</a>|
	  					<a href="delUser.action?username=${user.username }">删除</a></td>
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
		<form action="findUser.action" method="post" id="form2">
			<%-- <input type="hidden" name="page.class" value="${page }"> --%>
			
			<input type="hidden"  name="user.username" value="${user.username }">
			<input type="hidden"  name="user.sex" value="${user.sex }">
			<input type="hidden" id="cp" name="currentPage" value="${page.currentPage }">
		</form>
</body>
</html>