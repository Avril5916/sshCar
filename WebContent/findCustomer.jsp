<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="findCustomer.action" method="post">
<table align="center">
    	<tr>
			
			<td>身份证号:</td>
			<td><input type="text" name="customer.identity"  id="identity" onblur="identity();"/><span id="identitySpan"></span></td>
		    <td>姓名:</td>
		    <td><input type="text" name="customer.custname" id="custname" onblur="customers()"/><span id="custnameSpan"></span> </td>
		</tr>
		<tr>
			<td>地址:</td>
			<td><input type="text" name="customer.address"  id="address" onblur="address();"/><span id="addressSpan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;电话：</td>
			<td><input type="text" name="customer.phone"  id="phone" onblur="phone();"/><span id="phoneSpan"></span></td>
		</tr>
		<tr>
			<td>职业:</td>
			<td><input type="text" name="customer.career" id="career" onblur="career()"><span id="careerspan"></span></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;性别：</td>
			<td>
				<input type="radio" name="sex" value="1" checked/>男
				<input type="radio" name="sex" value="2"/>女
			</td>
		</tr>
		
		<tr align="center"> 
		<td>&nbsp;&nbsp;<input type="submit" value="确定" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" onclick="" /></td>
		</tr>
    </table>
    <input type="hidden" name="currentPage" value="1" >
</form>
</body>
</html>