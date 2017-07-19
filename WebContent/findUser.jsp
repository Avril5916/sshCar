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
<!--2.  a.有几处改动，下面几个属性name要改成user.XXX 
		b.选用户角色的地方要换成从数据库里查询来的角色List
		c.你忘写form表单了小姐姐...
		d.确定按钮暂时用submit，等会表单验证了再改成button-->
<form action="findUser.action" method="post">
 <table align="center">
    	<tr>
			<td>用户名：</td>
			<td><input type="text" name="user.username"  id="username" onblur="checkUname();"/><span id="usernameSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;身份证号：</td>
			<td><input type="text" name="user.identity"  id="identity" onblur="identity();"/><span id="identitySpan"></span></td>
		</tr>
		<tr>
			<td>用户密码：</td>
			<td><input type="password" name="user.userpwd"  id="userpwd" onblur="userpwd();"/><span id="userpwdSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：</td>
			<td><input type="text" name="user.phone"  id="phone" onblur="phone();"/><span id="phoneSpan"></span></td>
		</tr>
		<tr>
			<td>地址：</td>
			<td><input type="text" name="user.address"  id="address" onblur="address();"/><span id="addressSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;性别：</td>
			<td>
				<input type="radio" name="user.sex" value="男" checked/>男
				<input type="radio" name="user.sex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>职位：</td>
			<td><input type="text" name="user.position"  id="position" onblur="position();"/><span id="positionSpan"></span></td>
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
			<td><input type="text" name="user.fullname" id="fullname" onblur="fullname();"/><span id="fullnameSpan"></span></td>
		</tr>
		<tr align="center"> 
		<td>&nbsp;&nbsp;<input type="submit" value="确定"  /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="" /></td>
		</tr>
    </table>
	<input type="hidden" name="currentPage" value="1" >
</form>


</body>
</html>