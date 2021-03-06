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
				<div class="table-responsive">
				<table class="table table-hover">
				<tr><img src="${bm.blood}" style="width:300px;height:300px;" /></tr>
				<tr><td>结论</td><td>${bm.comment }</td><td>血液检查员</td><td>${bm.bloodInspector}</td></tr>				
					<!-- <tr><th>姓名</th><th>左眼视力</th><th>右眼视力</th><th>色觉</th><th>眼科检查员</th></tr>
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
