<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			var id = 0;
			function testClose(){
				var span = document.getElementById("spanID");
				id = window.setInterval(function(){
					span.innerHTML = span.innerHTML -1;
					if (span.innerHTML=='0') {
						window.close();
					}
				},1000);	
			}
		</script>

</head>
<body>
<table align="left">
		<tr>
		<td><h2>操作成功了呢！</h2></td>
		<td><h5>当前页面将在<span id="spanID" style="color: red;font-size: 28px;">5</span>秒后自动关闭</h5></td>
		<td><input type="button" value="关闭窗口" onclick="javascript:window.close()"></td>
			
		</tr>
 </table>	


</body>
</html>