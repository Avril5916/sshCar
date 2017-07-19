<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	
		function deleter(roleName) {
		  	if(confirm("您确定吗？")){
		  	document.getElementById('rolename').value = roleName;
		  	document.forms[0].submit();
		  	}else{
		  	return ;
	  		}
		}
		
	</script>
</head>
<body>
	<div>
		<table width="400px" align="center" border="1px solid black">
			<tr>
				<td>序号</td>
				<td>角色名</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${roles }" var="role">
				<tr>
					<td>${role.roleid }</td>
					<td>${role.rolename }</td>
					<td><a href="preUpdateRole.action?role.rolename=${role.rolename}">编辑</a></td>
					<td><a onclick="deleter('${role.rolename}')" style="cursor: pointer;color: blue;text-decoration: underline;" >删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="delRole.action" method="post">
		<input type="hidden" id="rolename" name="role.rolename"> 
		</form>
</body>
</html>