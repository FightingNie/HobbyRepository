<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="image/favicon.ico">
<style type="text/css">
	BODY {background-image: URL(image.jpg);
}
</style>
<title>系统注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/signin.css" rel="stylesheet">-->
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="register.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-register" action="register.action">
			<h2 class="form-register-heading">用户注册</h2>
			<input name="accountName" type="email" value=""
				class="form-control" placeholder="邮箱地址" required autofocus>
			<input name="password" value="" type="password" class="form-control"
				placeholder="密码" required>
			<input name="realName" type="text" value="" class="form-control"
				placeholder="真实姓名" required>
			<input name="cardNo" type="text" value="" class="form-control"
				placeholder="身份证号" required>
			<input name="nickName" type="text" value="" class="form-control"
				placeholder="用户名" required>
			<input name="phoneNumber" type="text" value="" class="form-control"
				placeholder="电话号码" required>
			<input name="age" type="text" value="" class="form-control"
				placeholder="年龄" required>
			<input name="sex" type="text" value="" class="form-control"
				placeholder="性别" required>
			<!-- <div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div> -->
			<button name="subBtn" class="btn" type="submit">确定</button>
		</form>

	</div>
	<!-- /container -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/index.js"></script>
</body>
</html>
