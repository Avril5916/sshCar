<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkId() {
	    var identity = document.getElementById("identity").value;  
	    //传统的ajax校验  
	    //1.创建异步交互对象，  
	    var xhr = createXmlHttp();  
	    //2设置监听  
	    xhr.onreadystatechange = function(){  
	        if(xhr.readyState == 4){  
	            if(xhr.status == 200){  
	                document.getElementById("span1").innerHTML = xhr.responseText;  
	            }  
	        }  
	    }  
	      
	    //3打开连接   get方式   路径 方法action名 不知道time是干嘛的  参数名+参数
	    xhr.open("GET","${pageContext.request.contextPath}/validateId.action?time="+new Date().getTime+"&identity="+identity,true);  
	    //4发送  
	    xhr.send(null);       
	    }     
	          
	    //创建XmlHttp对象  
	    function createXmlHttp(){  
	        var xmlHttp;  
	        try{  
	            xmlHttp= new XMLHttpRequest();  
	        }catch(e){  
	            try{  
	                xmlHttp=new ActiveXObject("Msxm12.XMLHTTP");  
	            }catch(e){  
	                try{  
	                    xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");  
	                }catch(e){}  
	            }             
	        }  
	          
	         return xmlHttp;      
	    }  
</script>

</head>
<body>
<form action="" method="post">
身份证号：<input type="text" name="identity" id="identity" onblur="checkId()" /><span id="span1"></span><br>
<input type="submit" value="提交" >
</form>
</body>
</html>