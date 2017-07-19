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
	<form action="returnCar.action" method="post">
		<table align="center" style="width: 400px" border="1px black solid" cellspacing="0" >
			<tr>
				<td>
					检查单号：<input type="text" name="checktable.checkid" value="${checktable.checkid}" readonly="readonly" >
				</td>
				<td>
					检查时间：<input type="text"  value="${checktable.checkdate}" readonly="readonly" >
				</td>
			</tr>
			<tr>
				<td>
					检查员：<input type="text" name="checktable.user.username" value="${checktable.user.username}" readonly="readonly" >
				</td>
				<td>
					属性：<input type="text" name="checktable.field" >
				</td>
			</tr>
			<tr>
				<td>
					问题：<input type="text" name="checktable.problem"  >
				</td>
				<td>
					赔费：<input type="text" name="checktable.paying" >
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"> </td>
			</tr>
		</table>
				<input type="hidden" name="tableid" value="${renttable.tableid}" >
	</form>
</div>
<hr/>
<div>
	<table>
		<tr>
			<td>
				出租单编号：<input type="text" value="${renttable.tableid }" readonly="readonly">
			</td>
			<td>
				预付金：<input type="text" value="${renttable.imprest }" readonly="readonly">
			</td>				
		</tr>
		<tr>
			<td>
				应付金额：<input type="text" value="${renttable.shouldpayprice }" readonly="readonly">
			</td>
			<td>
				实际支付：<input type="text" value="${renttable.price }" readonly="readonly">
			</td>				
		</tr>
		<tr>
			<td>
				起租日期：<input type="text" value="${renttable.begindate }" readonly="readonly">
			</td>
			<td>
				应归还日期：<input type="text" value="${renttable.shouldreturndate }" readonly="readonly">
			</td>				
		</tr>
	</table>
</div>
<hr>
<div>
	<table>
		<tr>
			<td>用户id：<input type="text" readonly="readonly" value="${renttable.customer.identity}"></td>
			<td>用户名：<input type="text" readonly="readonly" value="${renttable.customer.custname}"></td>
		</tr>
		<tr>
			<td>性别：<input type="text" readonly="readonly" value="${renttable.customer.sex}"></td>
			<td>地址：<input type="text" readonly="readonly" value="${renttable.customer.address}"></td>
		</tr>
		<tr>
			<td>电话：<input type="text" readonly="readonly" value="${renttable.customer.phone}"></td>
			<td>职业：<input type="text" readonly="readonly" value="${renttable.customer.career}"></td>
		</tr>
	</table>
</div>
<hr>
<div>
	<table>
		<tr>
			<td>车牌号：<input type="text" readonly="readonly" value="${renttable.car.carnumber }"></td>
			<td>车种：<input type="text" readonly="readonly" value="${renttable.car.cartype }"></td>
		</tr>
		<tr>
			<td>颜色：<input type="text" readonly="readonly" value="${renttable.car.color }"></td>
			<td>价格：<input type="text" readonly="readonly" value="${renttable.car.price }"></td>
		</tr>
		<tr>
			<td>租金：<input type="text" readonly="readonly" value="${renttable.car.rentprice }"></td>
			<td>押金：<input type="text" readonly="readonly" value="${renttable.car.deposit }"></td>
		</tr>
	</table>
</div>

</body>
</html>