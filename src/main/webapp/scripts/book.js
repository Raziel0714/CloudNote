function addBookAction() {
	// 获取请求参数
	var userId = getCookie("userId");
	var bookName = $("#input_notebook").val().trim();

	// 参数格式校验
	var ok = true;
	if (userId == null) {
		window.location.href = "log_in.html";
		ok = false;
	}
	if (bookName == "") {
		$("#name_span").html("笔记本名不能空");
		ok = false;
	}
	// 发送ajax请求
	if (ok) {
		$.ajax({
			url : path + "/book/add.do",
			type : "post",
			data : {
				"userId" : userId,
				"bookName" : bookName
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var book = result.data;
					var id = book.id;
					var name = book.name;
					// 关闭对话框
					closeAlertWindow();
					// 创建笔记本li
					createBookLi(id, name);
					alert("笔记本创建成功");
				}
			},
			error : function() {
				alert("笔记本创建失败!!!");
			}
		});
	}
}
function loadBooks(){
	// alert("JS调用");
	// 获取参数userId
	var userId=getCookie("userId");
	console.log(userId);
	//判断userId是否有效
	if(userId==null){
		window.location.href="log_in.html";
	}else{
		$.ajax({
			url:path+"/book/loadBooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					//获取笔记本集合
					var books=result.data;
					//循环处理
					for(var i=0;i<books.length;i++){
						//获取笔记本ID
						var bookId=books[i].id;
						//获取笔记本名称
						var bookName=books[i].name;
						//创建笔记本li元素
						createBookLi(bookId,bookName);
					}
				}
			},
			error:function(){
				alert("笔记本加载失败!");
			}
		});
	}
}

function createBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>';
	sli+= bookName;
	sli+='</a>';
	sli+='</li>';
	//将字符串转换成jQuery对象
	var $li=$(sli);
	//将userId绑定到li对象中
	$li.data("bookId",bookId);
	//将li对象添加到ul中
	$("#book_ul").append($li);
}


















