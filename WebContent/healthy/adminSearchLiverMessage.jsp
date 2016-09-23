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
				<div class="table-responsive">
				<table class="table table-hover">
				${message}
				<c:if test="${!empty lm}">
				<tr><img src="${lm.liver}" style="width:300px;height:300px;" /></tr>
				</c:if>
				<tr><td>结论</td><td>${lm.comment }</td><td>肝功检查员</td><td>${lm.liverInspector}</td></tr>				
				</table>
				<c:if test="${!empty lm}">
				<button class="btn btn-primary" data-toggle="modal" data-target="#confirmModal" data-itemid="${lm.id}">删除</button>
				<a href="updateLivaerMessageDemo?id=${lm.id}" class="btn btn-primary">修改记录</a>
				</c:if>
				<a href="addLiverMessageDemo?cardNo=${cardNo }" class="btn btn-primary" >添加记录</a>
				</div>
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

		<footer><p>&copy; Company 2014</p></footer>
	</div><!--/.container-->

	<!-- Modal -->
	<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">删除该条记录</h4>
	      </div>
	      <div class="modal-body">
	        <h4>你确定要删除该条记录？</h4>
	        <form id="confirmForm">
	        	<input type="hidden" name="id" class="confirmId"/>
	        	<div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" onclick="healthyActivity.delLiverMessage()">确认</button>
	      </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="publishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">内科记录</h4>
	      </div>
	      <div class="modal-body">
	      	<form id="publishForm">
	        	<!-- <input type="hidden" name="id" class="itemId"/> -->
	        	<div class="form-group">
					<label>身份证号：</label> <input type="text"
						class="form-control" name="cardNo" placeholder="身份证号"/>
				</div>
		        <div class="form-group">
					<label>血压：</label> <input type="text"
						class="form-control" name="bloodPressure" placeholder="血压"/>
				</div>
				<div class="form-group">
					<label>心肺听诊：</label> <input type="text"
						class="form-control" name="heartAndLung" placeholder="心肺听诊"/>
				</div>
				<div class="form-group">
					<label>结论：</label> <textarea 
						class="form-control" name="comment" placeholder="结论"></textarea>
				</div>
				<div class="form-group">
					<label>内科检查员：</label> <input type="text"
						class="form-control" name="internalInspector" placeholder="内科检查员"/>
				</div>
				<div class="form-group">
					<label>检查日期：</label> <input type="text"
						class="form-control" name="date" placeholder="yyyy-mm-dd"/>
				</div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" onClick="healthyActivity.submitInternalMessage()">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
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
	        <!-- <button type="button" class="btn btn-primary" onclick="healthyActivity.takePartIn()">参加活动</button>  -->
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
