<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="background-color: #2E4D75;"><h1><font color="white">查询汽车信息页面</font></h1></div>
<form action="findCar.action" method="post" enctype="multipart/form-data">
<table align="center">
    	<tr>
			
			<td>车号</td>
			<td><input type="text" name="car.carnumber"  id="carnumber" onblur="carnumber();"/></td>
		    <td>&nbsp;&nbsp;&nbsp;&nbsp;型号</td>
		    <td><input type="text" name="car.cartype" id="cartype" onblur="cartype()"/> </td>
		</tr>
		<tr>
			<td>颜色</td>
			<td><input type="text" name="car.color"  id="color" onblur="color();"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;价值：</td>
			<td><input type="text" name="car.price"  id="price" onblur="price();"/></td>
		</tr>
		<tr>
			<td>租金</td>
			<td><input type="text" name="car.rentprice"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;押金</td>
			<td>
			<input type="text" name="car.deposit"  id="deposit"  onblur="deposit()"/>
			</td>
		</tr>
		<tr>
		<td>租用情况</td>
		<td><select><option>未出租</option><option>已出租</option></select></td>
		</tr>
		<tr>
        <td>&nbsp;&nbsp;<input type="submit" value="确定" onclick="" /></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" onclick="" /></td>
		</tr>
    </table>
    <input type="hidden" name="currentPage" value="1">
    </form>
</body>
</html>