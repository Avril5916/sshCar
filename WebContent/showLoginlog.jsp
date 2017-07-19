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
  		<h3>查询登录记录显示列表</h3>
  		
  		 	<table border="1px" width="980px" style="margin-top: 5px">
  		 	<tr style="background-color: aqua;">
  		 		
  				
  				<th>id</th>
  				<th>用户名</th>
  				<th>ip</th>
  				<th>登录时间</th>
  				<th>删除</th>
  				
  			</tr>
  			<c:forEach items="${page.list}" var="log">
	  			<tr align="center">
	  				<td>${log.loginlogid }</td>
	  				<td>${log.loginname }</td>
	  				<td>${log.loginip }</td>
	  				<td>${log.logintime }</td>
	  				<td><a href="delLog.action?username=${log.loginlogid }">删除</a></td>
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
		<form action="finLoginlog.action" method="post" id="form2">
			<%-- <input type="hidden" name="page.class" value="${page }"> --%>
			
			<input type="hidden"  name="log.loginlogid" value="${log.loginlogid }">
			<input type="hidden"  name="log.loginip" value="${log.loginip }">
			<input type="hidden"  name="log.loginname" value="${log.loginname }">
			<input type="hidden"  name="log.logintime" value="${log.logintime }">
			<input type="hidden" id="cp" name="currentPage" value="${page.currentPage }">
		</form>
</body>
</html>