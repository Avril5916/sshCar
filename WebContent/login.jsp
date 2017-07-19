<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

<meta charset="utf-8">
<title>汽车租赁管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- <script type="text/javascript" src="js/login.js"></script> -->
</head>
<script>
	function checkAll(){
		var flag=checkName() & checkPwd()/*  & checkPwd2() */ ;
		if(flag){
			return true;
		}else{
			return false;
		}
	}
	function check(id,regex){
		var field=$("#"+id).val();
		var span=$("#"+id+"Span");
		if(null==field || ""==field){
			span.html("此项不能为空");
			return false;
		}else if(regex.test(field)){
			span.html("输入符合规范");
				return true;
		}else{
			span.html("格式不正确！");
			return false;
		}
	}
	
	function checkName(){
		return check("loginname",/^\w{3,10}$/)
	}
	function checkPwd(){
		return check("password",/^\w{3,10}$/)
		
	}
	/* function checkPwd2(){
		var pwd=$("#password").val();
		var pwd2=$("#password2").val();
		var span=$("#password2Span");
		if(pwd==pwd2){
			span.html("密码验证正确");
			return true;
		}else{
			span.html("两次密码不一致");
			return false;
		}
	} */
</script>
<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_form">
				<form action="login.action" id="login_form" method="post"　onsubmit="return checkAll();">
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label> 
						<input id="loginname" value="" name="user.username" type="text" class="form-control x319 in" 
						autocomplete="off" style="width: 150px;" onblur="checkName()"/>
						<span id="loginnameSpan">*必填项,字母数字下划线3~12位</span>
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" value="" name="user.userpwd" type="password" 
						class="password form-control x319 in" style="width: 150px;" onblur="checkPwd()">
						<span id="passwordSpan">*必填项,字母数字下划线3~12位</span>
					</div>
					<!-- <div class="form-group">
						<label for="j_password" class="t">确认密码：</label> 
						<input id="password2" value="" name="password2" type="password" 
						class="password form-control x319 in" style="width: 150px;" onblur="checkPwd2()">
						<span id="password2Span">*两次密码必须一致</span>
					</div> -->
					<div class="form-group">
						<label for="j_captcha" class="t">验证码：</label>
						 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="images/captcha.jpeg" class="m">
					</div>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="submit"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp; </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
			</div>
		</div>
		
	</div>
</div>

<!-- Javascript -->

<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>