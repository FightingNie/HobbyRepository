<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">
BODY {background-image: URL(image.jpg);
}
</style>
<link rel="icon" href="image/favicon.ico">

<title>健康管理系统</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="userManJS.js"></script>
<script src="main.js"></script>
</head>

<body style="background-color:#fff">
	<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<%@include file="../include/personalButton.jsp" %>
			<%@include file="../include/upperMenu.jsp" %>
		</ul>
		<form class="navbar-form navbar-left" role="search">
	      <div class="form-group">
	        <input type="text" class="form-control" placeholder="查询">
	      </div>
	      <button type="submit" class="btn btn-default">提交</button>
	    </form>
	</div><!-- /.nav-collapse -->
	</div><!-- /.container -->
	</nav><!-- /.navbar -->
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
				    <div class="item active">
				      <img src="image/carousel/first.jpg" alt="...">
				      <div class="carousel-caption">
				        <h1>欢迎回来, ${user.realName}!</h1>
						<p>健康生活，美好未来</p>
				      </div>
				    </div>
				    <div class="item">
				      <img src="image/carousel/healthyKnowledge.jpg" alt="...">
				      <div class="carousel-caption">
				         <h1>健康知识</h1>
				      </div>
				    </div>
				    <div class="item">
				      <img src="image/carousel/healthyAsk.jpg" alt="...">
				      <div class="carousel-caption">
				        <h1>健康咨询</h1>
				      </div>
				    </div>
				    <div class="item">
				      <img src="image/carousel/healthyActivity.jpg" alt="...">
				      <div class="carousel-caption">
				        <h1>健康活动</h1>
				      </div>
				    </div>
				    <div class="item">
				      <img src="image/carousel/dayCheck.jpg" alt="...">
				      <div class="carousel-caption">
				        <h1>每日体检</h1>
				      </div>
				    </div>
				  </div>
				
				  <!-- Controls -->
				  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
				<div class="table-responsive">
				<!-- <table class="table table-hover">
					<tr><th>登录邮箱</th><th>真实姓名</th><th>昵称</th><th>年龄</th><th>电话号码</th><th>所属角色</th><th>小区名称</th></tr>
					<c:forEach var="item" items="${userList}">
						<tr>
							<td>${item.accountName}</td>
							<%-- <td><a data-toggle="modal" data-target="#showUserModal" data-itemid="${item.id}" href="#">${item.realName}</a></td> --%>
							<td>${item.realName}</td>
							<td>${item.nickName}</td>
							<td>${item.age}</td>
							<td>${item.phoneNumber}</td>
							<td>${item.roleName}</td>
							<td>${item.societyName}</td>
							<td><a href="deleteUserById?id=${item.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table> -->
				<div class="container">
		<form class="form-user" action="addUser">
			<h2 class="form-register-heading">添加用户</h2>
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
			<select name="roleId"> 
				<option value="2">普通用户</option> 
				<option value="1">管理员</option> 
			</select>
			<br><br>
			<!-- <div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div> -->
			<button name="subBtn" class="btn" type="submit">确定</button>
		</form>

	</div>
	<!--
				<a href="addUser.jsp">添加用户</a>
				</div>
				<div class="center-block">${paging.nowPage}</div> 
				<form id="pageForm">
					<input id="pageSize" name="pageSize" type="hidden" value="8" />
					<input id="nowPage" name="nowPage" type="hidden" value="1" />
					<nav>
						<ul class="pager">
							<li>
								<a href="loadDataAction?nowPage=${paging.nowPage-1}&pageSize=${paging.pageSize}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
							<c:forEach var="page" items="${pNList}">
								<li><a href="loadDataAction?nowPage=${page}&pageSize=${paging.pageSize}">${page}</a></li>
							</c:forEach>
							<li>
								<a href="loadDataAction?nowPage=${paging.nowPage+1}&pageSize=${paging.pageSize}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</ul>
					</nav>
				</form> 
			</div>/span-->
			
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<c:forEach var="menu" items="${menuList}">
						<button id="${menu.jqId }" onclick="${menu.menuUrl}" class="list-group-item">${menu.menuName}</button>
					</c:forEach>
					<!-- <button onclick="hug.jumpHug()" class="list-group-item active" >健康信息</button>
					<button onclick="hug.jumpStudent()" class="list-group-item">健康资讯</button> -->
					<!-- <button onclick="main.tMessage()" class="list-group-item">导师信息</button>
					<button onclick="main.oMessage()" class="list-group-item">机构信息</button> -->
				</div>
			</div><!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer><p>&copy; Company 2014</p></footer>
	</div><!--/.container-->

	<div class="modal fade" id="showUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">用户信息</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<table class="table">
								<tr>
									<th>团名称:</th>
									<td class="hugname"></td>
								<tr>
									<th>发起人:</th>
									<td class="raiseuserid"><a href="#"></a></td>
								</tr>
								<tr>
									<th>约周几:</th>
									<td class="weekday"></td>
								</tr>
								<tr>
									<th>时长:</th>
									<td class=timelong></td>
								</tr>
							</table>
						</div>
						
						<div class="col-md-6">
							<table class="table">
								<tr>
									<th>团类型:</th>
									<td class="type"></td>
								</tr>
								<tr>
									<th>时间:</th>
									<td class="time"></td>
								</tr>
								<tr>
									<th>地点:</th>
									<td class="place"></td>
								</tr>
								<tr>
									<th>寄语:</th>
									<td class="descrip"></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<form id=showHugForm>
					<input id=hugId name="hugId" value="${hugId}" type="hidden">
					<input id=userId name="userId" value="${userId}" type="hidden">
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="hug.join()">加入他们</button>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/offcanvas.js"></script>
</body>
</html>
