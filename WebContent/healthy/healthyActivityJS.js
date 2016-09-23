var itemId;
var healthyActivity = {
	action:{
		submitActivity:"/healthy_home/submitActivity",
		takePartIn:"/healthy_home/takePartIn",
		delActive:"/healthy_home/delActive",
		delEyeMessage:"/healthy_home/delEyeMessage",
		delInternalMessage:"/healthy_home/delInternalMessage",
		delExternalMessage:"/healthy_home/delExternalMessage",
		delEarMessage:"/healthy_home/delEarMessage",
		delBloodMessage:"/healthy_home/delBloodMessage",
		delLiverMessage:"/healthy_home/delLiverMessage",
		submitEyeMessage:"/healthy_home/submitEyeMessage",
		submitInternalMessage:"/healthy_home/submitInternalMessage",
		submitExternalMessage:"/healthy_home/submitExternalMessage",
		submitEarMessage:"/healthy_home/submitEarMessage"
	},
	submitActivity:function(){
		$.ajax({
			url:healthyActivity.action.submitActivity,
			type : "post",
			async : false,
			data:$("#publishForm").serialize(),
			success:function(obj){
				alert(obj);
				window.location.href = "healthActivity";
			}
		});
	},
	submitEyeMessage:function(){
		$.ajax({
			url:healthyActivity.action.submitEyeMessage,
			type : "post",
			async : false,
			data:$("#publishForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "adminSearchEyeMessage";
			}
		});
	},
	submitInternalMessage:function(){
		$.ajax({
			url:healthyActivity.action.submitInternalMessage,
			type : "post",
			async : false,
			data:$("#publishForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "adminSearchEyeMessage";
			}
		});
	},
	submitExternalMessage:function(){
		$.ajax({
			url:healthyActivity.action.submitExternalMessage,
			type : "post",
			async : false,
			data:$("#publishForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "adminSearchEyeMessage";
			}
		});
	},
	submitEarMessage:function(){
		$.ajax({
			url:healthyActivity.action.submitEarMessage,
			type : "post",
			async : false,
			data:$("#publishForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "adminSearchEyeMessage";
			}
		});
	},
	takePartIn:function(){
		$.ajax({
			url:healthyActivity.action.takePartIn,
			type : "post",
			async : false,
			data:$("#takePartInForm").serialize(),
			success:function(obj){
				alert(obj);
				window.location.href = "takePartInActivity";
			}
		});
	},
	delActive:function(){
		$.ajax({
			url:healthyActivity.action.delActive,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				window.location.href = "healthActivity";
			}
		});
	},
	delEyeMessage:function(){
		$.ajax({
			url:healthyActivity.action.delEyeMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delEyeMessage";
			}
		});
	},
	delInternalMessage:function(){
		$.ajax({
			url:healthyActivity.action.delInternalMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delInternalMessage";
			}
		});
	},
	delExternalMessage:function(){
		$.ajax({
			url:healthyActivity.action.delExternalMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delInternalMessage";
			}
		});
	},
	delEarMessage:function(){
		$.ajax({
			url:healthyActivity.action.delEarMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delInternalMessage";
			}
		});
	},
	delBloodMessage:function(){
		$.ajax({
			url:healthyActivity.action.delBloodMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delInternalMessage";
			}
		});
	},
	delLiverMessage:function(){
		$.ajax({
			url:healthyActivity.action.delLiverMessage,
			type : "post",
			async : false,
			data:$("#confirmForm").serialize(),
			success:function(obj){
				alert(obj);
				//window.location.href = "delInternalMessage";
			}
		});
	}
};
$(function() {
	$("#healthActivityButton").attr("class","list-group-item active");
	//弹出模态框事件主注册
	$('#healthyActivityModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget);
		var theme = button.data('theme');
		var content = button.data('content');
		var time = button.data('time');
		var addr = button.data('addr');
		var membersStr = button.data('membersstr');
		itemId = button.data('itemid');
		var modal = $(this);
		modal.find('.activityTheme').text(theme);
		modal.find('.activityContent').text(content);
		modal.find('.activityTime').text(time);
		modal.find('.activityAddr').text(addr);
		modal.find('.healthyActivityId').val(itemId);
		modal.find('.dMembersStr').remove();
		modal.find('.membersStr').append("<div class=\"dMembersStr\">"+membersStr+"</div>");
	});
	$('#healthyAsnwerModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget);
		var title = button.data('title');
		var question = button.data('question');
		var answer = button.data('answer');
		var modal = $(this);
		modal.find('.answerTtile').text(title);
		modal.find('.answerQuestion').text(question);
		modal.find('.answerAnswer').text(answer);
	});
	
	$('#confirmModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget);
		var itemId = button.data('itemid');
		var modal = $(this);
		modal.find('.confirmId').val(itemId);
	});
});