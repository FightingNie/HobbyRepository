<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<li class="dropdown">
  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">体检记录 <span class="caret"></span></a>
  <ul class="dropdown-menu">
    <li><a href="createEyeMessage">眼科</a></li>
   <li><a href="createInternalMessage" >内科</a></li>
   <li><a href="createExternalMessage" >外科</a></li>
   <li><a href="createEarMessage" >耳科</a></li>
   <li><a href="createBloodMessage" >血常规</a></li>
   <li><a href="createLiverMessage" >肝功</a></li>
  </ul>
</li>
<li class="dropdown">
   <a href="#" onClick="main.healthActivityClick()">健康活动<span class="caret"></span></a>
</li>
<li class="dropdown">
  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">信息交流反馈<span class="caret"></span></a>
  <ul class="dropdown-menu">
    <li><a href="#" onClick="main.adviceClick()">答复建议</a></li>
    <li><a href="#" onClick="main.rejectClick()">处理投诉</a></li>
    <li><a href="adminSystemMessageList">发布消息</a></li>
  </ul>
</li>
<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统管理 <span class="caret"></span></a>
   <ul class="dropdown-menu">
     <li><a href="#" onClick="main.userClick()">用户信息管理</a></li>
     <li><a href="#" onClick="main.outLogin()">退出登录</a></li>
     <!-- <li><a href="#" onClick="main.menuClick()">菜单信息</a></li> -->
   </ul>
</li>