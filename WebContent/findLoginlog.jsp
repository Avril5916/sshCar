<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<form action="finLoginlog.action" method="post">
	登录记录id：<input type="text" name="log.loginlogid">
	登录用户名：<input type="text" name="log.loginname">
	登录ip地址：<input type="text" name="log.loginip">
	登录时间：<input type="text" name="log.logintime">
	<input type="hidden" name="currentPage" value="1">
	<input type="submit" value="查找">
</form>
</div>
</body>
</html>