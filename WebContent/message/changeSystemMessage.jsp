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
<script src="message/leaveMessageJS.js"></script>
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
				<form id="changeSystemMessageForm" action="changeSystemMessage">
					<div class="row">
						<div class="form-group col-md-4">
						
							<label>标题：</label> <input type="text" value="${systemMe.title}"
								class="form-control title" name="title" placeholder="标题">
						</div>
						<div class="form-group col-md-4">
							<label>消息内容:</label> <input type="text" value="${systemMe.content}"
								class="form-control content" name="content" placeholder="消息内容">
						</div>
					</div>
					<input type="hidden" value="${systemMe.id }" name="id">
					<button class="btn btn-primary" onclick="changeSystemMessage">修改</button>
				</form>
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

		<footer><p>&copy; Company 2014</p></footer>
	</div><!--/.container-->

	<!-- Placed at the end of the document so the pages load faster -->

	<!-- Modal -->
	<div class="modal fade" id="showMessageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改留言</h4>
	      </div>
	      <div class="modal-body">
	        <form id="changeMyMessageForm" action="changeMyMessage">
		        <div class="form-group">
					<label>修改：</label> <textarea
						class="form-control content" name="content" placeholder="修改留言"></textarea>
				</div>
				<input name="id" type="hidden" class="id">
				<input type="submit" name="submit" value="修改"/>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	       <!-- <button type="button" class="btn btn-primary" onClick="window.location.href('changeMyMessage')">修改</button> --> 
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/offcanvas.js"></script>
</body>
</html>
