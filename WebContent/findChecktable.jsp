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
	<form action="findChecktable.action" method="post">
		id:<input type="text" name="checktable.checkid">
		属性：<input type="text" name="checktable.field"><br>
		问题:<input type="text" name="checktable.problem">
		时间：???
		<input type="submit" value="提交">
		<input type="hidden" value="1" name="currentPage">
	</form>
	<h4>${msg }</h4>
</div>

</body>
</html>