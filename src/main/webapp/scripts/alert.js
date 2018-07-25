//弹出删除笔记对话框
function deleteNoteWindow(){
	//弹出出对话框
	$("#can").load("alert/alert_delete_note.html");
	//显示背景色
	$(".opacity_bg").show();
}
//弹出新建笔记对话框
function addNoteAlertWindow(){
	var $li=$("#book_ul a.checked").parent();
	if($li.length==0){
		alert("请选择笔记本");
	}else{
		//弹出出对话框
		$("#can").load("alert/alert_note.html");
		//显示背景色
		$(".opacity_bg").show();
	}
	
}
//弹出新建笔记本对话框
function addBookAlertWindow(){
	//弹出出对话框
	$("#can").load("alert/alert_notebook.html");
	//显示背景色
	$(".opacity_bg").show();
}
//关闭对话框
function closeAlertWindow(){
	//清空出对话框
	$("#can").html("");
	//隐藏背景色
	$(".opacity_bg").hide();
}