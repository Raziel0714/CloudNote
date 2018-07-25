function shareNoteAction(){
					//获取参数
					var $li=$(this).parents("li");
					var noteId=$li.data("noteId");
					console.log(noteId);
					//发送请求
					$.ajax({
						url:path+"/share/add.do",
						type:"post",
						data:{"noteId":noteId},
						dataType:"json",
						success:function(result){
							if(result.state==0){
								alert(result.message);
							}
						},
						error:function(){
							alert("笔记分享失败");
						}
					});
				}