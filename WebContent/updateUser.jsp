<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateUser.action" method="post">
<table align="center">
    	<tr>
			<td>登录名：</td>
			<td><input type="text" name="user.username"  id="username" onblur="checkUname();" value="${user.username }" readonly="readonly"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;身份证号：</td>
			<td><input type="text" name="user.identity"  id="identity" onblur="checkidentity();" value="${user.identity }"/></span></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text"name="user.fullname"id="name" onblur="checkName()" value="${user.fullname }"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：</td>
			<td><input type="text" name="user.phone" id="phone" onblur="checkPhone();" value="${user.phone }"/></span></td>
		</tr>
		<tr>
			<td>地址：</td>
			<td><input type="text" name="user.address"  id="address" onblur="checkAddress();" value="${user.address }"/><span id="addressSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;性别：</td>
			<td>
				<input type="radio" name="user.sex" value="男" checked/>男
				<input type="radio" name="user.sex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>用户类型：</td>
			<td><input type="text" name="user.position" " id="position" onblur="checkPosition();" value="${user.position }"/><span id="positionSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;用户类型：</td>
			<td>
				<select id="usertype" name="user.roleid">
					<option value="${user.role.roleid }">${user.role.rolename }</option>
					<c:forEach items="${roles }" var="role">
						<option value="${role.roleid }">${role.rolename }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr align="center"> 
		<td>&nbsp;&nbsp;<input type="submit" value="确定" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="修改密码"></td>
		</tr>
    </table>
</form>



</body>
</html>