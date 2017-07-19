<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="background-color: #2E4D75;"><h1><font color="white">更新汽车信息页面</font></h1></div>
<form action="updateCar.action" method="post" enctype="multipart/form-data">
<table align="center">
    	<tr>
			
			<td>车号</td>
			<td><input type="text" name="car.carnumber"  id="carnumber" onblur="carnumber();" value="${car.carnumber}" readonly="readonly"/></td>
		    <td>&nbsp;&nbsp;&nbsp;&nbsp;型号</td>
		    <td><input type="text" name="car.cartype" id="cartype" onblur="cartype()" value="${car.cartype }"/> </td>
		</tr>
		<tr>
			<td>颜色</td>
			<td><input type="text" name="car.color"  id="color" onblur="color();" value="${ car.color}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;价值：</td>
			<td><input type="text" name="car.price"  id="price" onblur="price();" value="${car.price}"/></td>
		</tr>
		<tr>
			<td>租金</td>
			<td><input type="text" name="car.rentprice" id="rentprice" value="${car.rentprice}"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;押金</td>
			<td>
			<input type="text" name="car.deposit"  id="deposit"  onblur="deposit()" value="${car.deposit }"/>
			</td>
		</tr>
		<tr>
		<td>租用情况</td>
		<td><input type="text" name="car.isrenting" id="isrenting" value="${car.isrenting }"/></td>
		</tr>
		<!-- 图片加载项 -->
		<tr>
		<td>图片预览</td>
		<td><img alt="" src=""/></td>
		<td><div align="center">更改汽车图片</div></td>
		<td><input type="file" name="file" id="file"></td>
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