<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.fatherLabel{
		position: relative;
		left: 40px
	}
	.sonLabel{
		position: relative;
		left: 60px
	}
</style>
<script type="text/javascript">
	function selSub(fi) {
		var boxes=document.getElementsByName("mlist"); 
		if(document.getElementById(fi).checked){
			 
			for(var i=0;i<boxes.length;i++){  //对标签进行遍历 
				if(boxes[i].getAttribute("class")==fi){
					boxes[i].checked=true;
				}
			} 
		} else{
			for(var i=0;i<boxes.length;i++){  //对标签进行遍历 
				if(boxes[i].getAttribute("class")==fi){
					boxes[i].checked=false;
				}
			} 
		}
	} 
		    
		
	
</script>
</head>
<body>
<form action="addNewRole.action" method="post">
	<div>
		<c:forEach items="${menus }" var="menu">
			<c:choose>
				<c:when test="${menu.fatherid==1}">
					<div class="fatherLabel">
						<input name="mlist" id="${menu.menuid }" type="checkbox" value="${menu.menuid }" onchange="selSub(${menu.menuid })">${menu.name }
					</div>
				</c:when>
				<c:otherwise>
					<div class="sonLabel">
						<input name="mlist" class="${menu.fatherid }" type="checkbox" value="${menu.menuid }">${menu.name }
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
	角色名：<input type="text" name="role.rolename">
	<input type="submit" value="添加">
</form>
</body>
</html>