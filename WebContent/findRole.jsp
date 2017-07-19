<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center"><h3>角色管理</h3></div>
		<form action="findRole.action" method="post">
			<input type="text" name="role.rolename">
			<input type="submit" value="查询">
			<input type="reset" value="重置">
		</form>
		<a href="preAddNewRole.action">添加新角色</a>
</body>
</html>