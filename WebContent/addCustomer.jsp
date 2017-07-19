<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addCustomer.action" method="post" name="form1">
<table align="center">
    	<tr>
			<td>身份证号：</td>
			<td><input type="text" name="customer.identity"  id="identity" onblur="identity();" /></td>
		    <td>&nbsp;&nbsp;&nbsp;&nbsp;姓名：</td>
		    <td><input type="text" name="customer.custname" id="custname" onblur="customers()" /> </td>
		</tr>
		<tr>
			<td>地址：</td>
			<td><input type="text" name="customer.address"  id="address" onblur="address();" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;电话：</td>
			<td><input type="text" name="customer.phone"  id="phone" onblur="phone();" /></td>
		</tr>
		<tr>
			<td>职业</td>
			<td><input type="text" name="customer.career" id="career" onblur="career()" ></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;性别：</td>
			<td>
				<input type="radio" name="customer.sex" value="男" checked />男
				<input type="radio" name="customer.sex" value="女" />女
			</td>
		</tr>
		
		<tr align="center"> 
		<td>&nbsp;&nbsp;<input type="submit" value="确定" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"  /></td>
		</tr>
    </table>
    </form>
</body>
</html>