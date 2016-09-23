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
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="main.js"></script>
<script src="healthy/healthyActivityJS.js"></script>
</head>

<body style="background-color:#fff">
	<input type="hidden" id="userId" value="${user.id}"/>
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
			<%@include file="../include/nomalPersonUpperMenu.jsp" %>
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
				<table class="table table-hover">
				${message}
				<tr><th>次数</th><th>体检日期</th><th>详情</th></tr>
					<c:forEach var="bd" items="${bodyBetails}">
						<tr><td>第${bd.times}次</td><td>${bd.date}</td><td><a href="externalExamDetail?id=${bd.id}">查看详情</td></tr>
					</c:forEach>
				<!--
				
				 <tr><td>姓名</td><td>${user.realName}</td><td>年龄</td><td>${user.age}</td><td>性别</td><td>${user.sex}</td><td>身高</td><td>${bodyBetail.height}cm</td></tr>
				<tr><td>体重</td><td>${bodyBetail.weight}kg</td><td>左眼视力</td><td>${bodyBetail.leftEye}</td><td>右眼视力</td><td>${bodyBetail.rightEye}</td><td>色觉</td><td>${bodyBetail.colorSense}</td></tr>
				<tr><td>血压</td><td>${bodyBetail.bloodPressure}</td><td>心肺听诊</td><td>${bodyBetail.heartAndLung}</td><td>皮肤</td><td>${bodyBetail.skin}</td><td>脊柱四肢</td><td>${bodyBetail.extremitiesAndSpine}</td></tr>
				<tr><td>左耳听力</td><td>${bodyBetail.leftEar}</td><td>右耳听力</td><td>${bodyBetail.rightEar}</td><td>血液</td><td>${bodyBetail.blood}</td><td>胸透</td><td>${bodyBetail.chestX}</td></tr>
				<tr><td>眼科检查员</td><td>${bodyBetail.eyeInspector}</td><td>内科检查员</td><td>${bodyBetail.internalInspector}</td><td>外科检查员</td><td>${bodyBetail.externalInspector}</td></tr>
				<tr><td>耳科检查员</td><td>${bodyBetail.earInspector}</td><td>血液检查员</td><td>${bodyBetail.bloodInspector}</td><td>胸部透视检查员</td><td>${bodyBetail.chestInspector}</td></tr>				
					<tr><th>姓名</th><th>左眼视力</th><th>右眼视力</th><th>色觉</th><th>眼科检查员</th></tr>
						<tr>
							<td>${user.realName}</td><td>${bodyBetail.leftEye}</td><td>${bodyBetail.rightEye}</td>
							<td>${bodyBetail.colorSense}</td>
							<td>${bodyBetail.eyeInspector}</td>
						</tr> -->
				</table>
				<!-- <a href="createHealthyExam.jsp"><font color="black">添加体检记录</font></a> -->
				</div>
			</div><!--/span-->
			
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<c:forEach var="menu" items="${menuListF}">
						<button id="${menu.jqId }" onclick="${menu.menuUrl}" class="list-group-item">${menu.menuName}</button>
					</c:forEach>
				</div>
				<div class="list-group">
					<c:forEach var="menu" items="${menuListS}">
						<button id="${menu.jqId }" onclick="${menu.menuUrl}" class="list-group-item">${menu.menuName}</button>
					</c:forEach>
				</div>
			</div><!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer><p>&copy; Company </p></footer>
	</div><!--/.container-->

	<!-- Modal -->
	<div class="modal fade" id="healthyActivityModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">活动详情</h4>
	      </div>
	      <div class="modal-body">
	        <h4 class="modal-title">活动主题:</h4>
	        <p class="activityTheme"></p>
	        <hr></hr>
	        <h4>活动内容:</h4>
	        <p class="activityContent"></p>
	        <hr></hr>
	        <h4>活动时间:</h4>
	        <p class="activityTime"></p>
	        <hr></hr>
	        <h4>活动地点:</h4>
	        <p class="activityAddr"></p>
	        <hr></hr>
	        <h4>参加人员:</h4>
	        <p class="membersStr"><div class="dMembersStr"></div></p>
	        <form id="takePartInForm">
	        	<input name="healthyActivityId" type="hidden" class="healthyActivityId"/>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" onclick="healthyActivity.takePartIn()">参加活动</button> 
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
