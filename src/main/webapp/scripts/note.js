function deleteNoteAction(){
					//获取请求参数
					var $li=$("#note_ul a.checked").parent();
					var noteId=$li.data("noteId");
					console.log(noteId);
					//发送请求
					$.ajax({
						url:path+"/note/delete.do",
						type:"post",
						data:{"noteId":noteId},
						dataType:"json",
						success:function(result){
							if(result.state==0){
								$li.remove();
								alert("删除笔记成功");
							}
						},
						error:function(){
							alert("删除笔记失败");
						}
					});
				}

function showNoteMenu(){
	//展开下拉菜单
	$("#note_ul").on("click",".btn_slide_down",function(){
		//隐藏笔记菜单
		$("#note_ul div").hide();
		//获取菜单对象
		var note_menu=$(this).parents("li").find("div");
		//显示菜单
		note_menu.show();
		//选中效果设置
		$("#note_ul a").removeClass("checked");
		$(this).parent().addClass("checked");
		//阻止冒泡
		return false;
	});
	//点击body范围,隐藏笔记菜单
	$("body").click(function(){
		$("#note_ul div").hide();
	});
}
function addNoteAction(){
					//获取参数
					var noteTitle=$("#input_note").val().trim();
					var userId=getCookie("userId");
					var $li=$("#book_ul a.checked").parent();
					var bookId=$li.data("userId");
					//发送Ajax请求
					$.ajax({
						url:path+"/note/add.do",
						type:"post",
						data:{
								"userId":userId,
								"bookId":bookId,
								"noteTitle":noteTitle},
						dataType:"json",
						success:function(result){
							if(result.state==0){
								var note=result.data;
								var id=note.id;
								var title=note.title;
								createNoteLi(id,title);
								alert("创建笔记成功");
							}
						},
						error:function(){
							alert("创建笔记失败");
						}
					});
				}
//加载笔记列表
function loadNotesAction(){
	console.log($(this));
	// 设置记录选中效果
	$("#book_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	// 获取参数bookId
	var bookId = $(this).data("bookId");
	console.log(bookId);
	// 发送Ajax请求
	$.ajax({
		url : path + "/note/list.do",
		type : "post",
		data : {
			"bookId" : bookId
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0) {
				// 获取笔记集合
				var notes = result.data;
				// 清空笔记列表
				$("#note_ul li").remove();
				// 遍历集合中的笔记记录
				for (var i = 0; i < notes.length; i++) {
					// 获取笔记ID
					var noteId = notes[i].id;
					// 获取笔记标题
					var noteTitle = notes[i].title;
					// 创建笔记li元素
					createNoteLi(noteId, noteTitle);
				}
			}
		},
		error : function() {
			alert("笔记列表加载失败");
		}
	});
}
//创建笔记li元素
function createNoteLi(noteId,noteTitle){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+=noteTitle;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli+='</a>';
	sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='</dl>';
	sli+='</div>';
	sli+='</li>';
	//将sli转换成jQuery对象
	var $li=$(sli);
	//绑定noteId
	$li.data("noteId",noteId);
	$("#note_ul").append($li);
}








