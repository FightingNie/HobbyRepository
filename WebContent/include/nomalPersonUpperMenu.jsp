<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<li class="dropdown">
   <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" >体检记录<span class="caret"></span></a>
   <ul class="dropdown-menu">
   <li><a href="eyeExamination" >眼科</a></li>
   <li><a href="internalExamination" >内科</a></li>
   <li><a href="externalExamination" >外科</a></li>
   <li><a href="earExamination" >耳科</a></li>
   <li><a href="bloodExamination" >血常规</a></li>
   <li><a href="liverExamination" >肝功</a></li>
   </ul>
</li>
<li class="dropdown">
   <a href="illnessRecords" >疾病记录<span class="caret"></span></a>
</li>
<li class="dropdown">
   <a href="#" onClick="main.healthActivityClick()" >健康活动<span class="caret"></span></a>
</li>
<li class="dropdown">
   <a href="showPsychologicalHealthy" >心理健康<span class="caret"></span></a>
</li>
   <!-- class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" -->
  <!-- <ul class="dropdown-menu"> --> 
     <!-- <li><a href="#" onClick="main.healthKnowledgeClick()">体检记录</a></li> -->
     <!-- <li><a href="healthExamination" >体检记录</a></li> --> 
    <!-- <li><a href="illnessRecords">疾病记录</a></li> -->  
     <!-- <li><a href="#" onClick="main.healthActivityClick()">健康活动</a></li> --> 
     <!-- <li role="separator" class="divider"></li> -->
     <!-- <a href="showPsychologicalHealthy">心理健康</a></li> --> <li>
     <!-- <li role="separator" class="divider"></li>
     <li><a href="#" onClick="main.seeDoctorClick()">就医通道</a></li> -->
   <!--  </ul> -->
 
 <li class="dropdown">
   <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">信息交流平台 <span class="caret"></span></a>
   <ul class="dropdown-menu">
     <li><a href="#" onClick="main.adviceClick()">我有建议</a></li>
     <li><a href="#" onClick="main.rejectClick()">我要投诉</a></li>
     <li role="separator" class="divider"></li>
     <li><a href="myLeaveMessages">我的留言</a></li>
     <li><a href="systemMessageList">平台信息</a></li>
   </ul>
 </li>
 <!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">社区拼车 <span class="caret"></span></a>
    	<ul class="dropdown-menu">
     	<li><a href="#" onClick="main.myCarHugClick()">我的拼车</a></li>
      <li><a href="#" onClick="main.makeCarHugClick()">发起拼车</a></li>
      <li role="separator" class="divider"></li>
      <li><a href="#" onClick="main.carHugListClick()">拼车列表</a></li>
     </ul>
    </li> -->