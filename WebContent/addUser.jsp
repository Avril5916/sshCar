<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="addUser.action" method="post" name="form1">
 <table align="center">
    	<tr>
			<td>登录名：</td>
			<td><input type="text" name="user.username" alt="用户名" id="username" onblur="checkUname();"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;身份证号：</td>
			<td><input type="text" name="user.identity" alt="身份证号" id="identity" onblur="identity();"/></td>
		</tr>
		<tr>
			<td>用户密码：</td>
			<td><input type="password" name="user.userpwd"  id="userpwd" onblur="userpwd();"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：</td>
			<td><input type="text" name="user.phone"  id="phone" onblur="phone();"/></td>
		</tr>
		<tr>
			<td>地址：</td>
			<td><input type="text" name="user.address"  id="address" onblur="address();"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;性别：</td>
			<td>
				<input type="radio" name="user.sex" value="1" checked/>男
				<input type="radio" name="user.sex" value="2"/>女
			</td>
		</tr>
		<tr>
			<td>用户类型：</td>
			<td><input type="text" name="user.position"  id="position" onblur="position();"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;用户类型：</td>
			<td>
				<select id="usertype" name="user.roleid">
					<option value="">----请选择----</option>
					<c:forEach items="${roles }" var="role">
						<option value="${role.roleid }">${role.rolename }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="user.fullname"  id="fullname" onblur="fullname();"/></td>
		</tr>
		<tr align="center"> 
		<td>&nbsp;&nbsp;<input type="submit" value="确定" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
		</tr>
    </table>
</form>
</body>
</html>