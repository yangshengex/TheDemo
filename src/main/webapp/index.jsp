<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"  href="#">欢迎使用Web图书馆</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a><i class="glyphicon glyphicon-book" >
                </i> 轻松掌握图书馆信息，节省时间，快乐学习</a></li>
             </ul>
    </div><!-- /.container-fluid -->
</nav>
<h1>${some}</h1>
<h1>${user.username}</h1>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-right" role="search" action="http://localhost:8080/mycloud/login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="account" autofocus required placeholder="请输入账号">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="pwd" required placeholder="请输入密码">
                </div>
                <button type="submit" class="btn btn-info">登录</button>
                <div class="form-group">
                    <a href="" class="btn btn-success">注册</a>
                </div>
            </form>
        </div><!-- /.navbar-collapse -->
<div class="ca"></div>
<button type="button" class="btn btn-primary" title="Popover title" data-container="body" data-toggle="popover"  data-trigger="focus" data-content="顶部的 Popover 中的一些内容">
顶部的 Popover
</button>

<h1 id="medialog" class="btn btn-info">点击弹出对话框</h1>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title text-center"  id="myModalLabel">用户的提示信息</h4>
        </div>
    </div>
  </div>
<hr>
<hr>

</body>
<script type="text/javascript">
$("[data-toggle='popover']").popover({
	placement:'bottom',
	hide:300
});
/*让所有有data-tooltip属性的标签执行tooltip函数，以免页面上标签的提示失效*/
$("[rel]").tooltip();
$("[data-toggle='popover']").modal('hide');

$('#medialog').click(function(){
	//动态给出弹出位置
  $('#myModal').css({
      'top': function () {
          //$(window).height()浏览器高度,然后减去自己的高度/2,实现弹出层垂直居中
         // alert($(window).height());
         // alert($(document).height());
          return $(window).height()-250;

      } ,
      'left':function(){
      	// alert($('#myModal').width())
      	 // alert($('#myModal').width())
      	 return $(document).width()-600;
     }
  });
$('#myModal').modal({
	show:true,
	backdrop:false,
	keyboard:false
});
});
</script>
</html>