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
<h1>${some}</h1>
<h1>${user.username}</h1>

<nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">云盘 Resource Anywhere</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页 <span class="sr-only">(current)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的云盘 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/mycloud/queryMyFiles" target="main">我的文件</a></li>
                        <li><a href="upload.jsp" target="main">上传文件</a></li>
                        <li><a href="#">共享文件</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">站内信<span class="badge">50</span><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">写邮件</a></li>
                        <li><a href="#">收件箱<span class="badge">50</span></a></li>
                        <li><a href="#">发件箱</a></li>
                        <li><a href="#">草稿箱</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Collect the nav links, forms, and other content for toggling -->
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
    </div><!-- /.container-fluid -->
</nav>
<hr>
<hr>
<div class="ca"></div>
<button type="button" class="btn btn-primary" title="Popover title" data-container="body" data-toggle="popover"  data-content="顶部的 Popover 中的一些内容">
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