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
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/main.js"></script>
<script src="${pageContext.request.contextPath}/personalJS.js"></script>
</head>

<body style="background-color:#fff">
	<input type="hidden" id="userId" value="${user.id}"/>
	<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
			<span class="sr-only">导航</span>
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
				<form id="createHealthyExamForm" action="createHealthyExam">
					<div class="row">
						<div class="form-group col-md-4">
							<label>左眼视力:</label> <input type="text"
								class="form-control" name="leftEye" placeholder="左眼视力">
						</div>
						<div class="form-group col-md-6">
							<label>右眼视力:</label> <input type="text"
								class="form-control" name="rightEye" placeholder="右眼视力">
						</div>
						<div class="form-group col-md-6">
							<label>色觉:</label> <input type="text"
								class="form-control" name="colorSense" placeholder="色觉">
						</div>
						<div class="form-group col-md-6">
							<label>眼科检查员:</label> <input type="text"
								class="form-control" name="eyeInspector" placeholder="眼科检查员">
						</div>
						<div class="form-group col-md-4">
							<label>身高:</label> <input type="text"
								class="form-control height" name="height" placeholder="身高">
						</div>
						<div class="form-group col-md-4">
							<label>体重:</label> <input type="text"
								class="form-control weight" name="weight" placeholder="体重">
						</div>
						<div class="form-group col-md-4">
							<label>皮肤:</label> <input type="text"
								class="form-control" name="skin" placeholder="皮肤">
						</div>
						<div class="form-group col-md-6">
							<label>脊柱四肢:</label> <input type="text"
								class="form-control" name="extremitiesAndSpine" placeholder="脊柱四肢">
						</div>
						<div class="form-group col-md-4">
							<label>其他:</label> <input type="text"
								class="form-control" name="others" placeholder="其他">
						</div>
						<div class="form-group col-md-6">
							<label>外科检查员:</label> <input type="text"
								class="form-control" name="externalInspector" placeholder="外科检查员">
						</div>
						<div class="form-group col-md-4">
							<label>血压:</label> <input type="text"
								class="form-control" name="bloodPressure" placeholder="血压">
						</div>
						<div class="form-group col-md-4">
							<label>心肺听诊:</label> <input type="text"
								class="form-control" name="heartAndLung" placeholder="心肺听诊">
						</div>
						<div class="form-group col-md-6">
							<label>内科检查员:</label> <input type="text"
								class="form-control" name="internalInspector" placeholder="内科检查员">
						</div>
						<div class="form-group col-md-6">
							<label>左耳听力:</label> <input type="text"
								class="form-control" name="leftEar" placeholder="左耳听力">
						</div>
						<div class="form-group col-md-4">
							<label>右耳听力:</label> <input type="text"
								class="form-control" name="rightEar" placeholder="右耳听力">
						</div>
						<div class="form-group col-md-6">
							<label>耳科检查员:</label> <input type="text"
								class="form-control" name="earInspector" placeholder="耳科检查员">
						</div>
						<div class="form-group col-md-6">
							<label>血液:</label> <input type="text"
								class="form-control" name="blood" placeholder="血液">
						</div>
						<div class="form-group col-md-6">
							<label>血液检查员:</label> <input type="text"
								class="form-control" name="bloodInspector" placeholder="血液检查员">
						</div>
						<div class="form-group col-md-6">
							<label>胸透:</label> <input type="text"
								class="form-control" name="chestX" placeholder="胸透">
						</div>
						<div class="form-group col-md-6">
							<label>胸透检查员:</label> <input type="text"
								class="form-control" name="chestInspector" placeholder="胸透检查员">
						</div>
					</div>
					<button class="btn btn-primary" onclick="createHealthyExam">添加</button>
				</form>
			</div><!--/span-->
		
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<button id="personalMessage" onclick="main.personalMessage()" class="list-group-item">我的信息</button>
					<button id="outLogin" onclick="main.outLogin()" class="list-group-item">退出登录</button>
				</div>
			</div><!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer><p>&copy; </p></footer>
	</div><!--/.container-->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/offcanvas.js"></script>
</body>
</html>
