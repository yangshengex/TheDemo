<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--引入所需资源 这里因为head.jsp中已经有了资源文件，所以我们就不用再引入了 不然一些js操作不能执行-->
<script src="./resources/js/htmlJs/validateUser.js"></script>
</head>
<body >
<jsp:include flush="true" page="/resources/common/head.jsp"></jsp:include>
<h1>${some}</h1>
<h1>${user.username}</h1>
<c:if test = "${user.username!=null}">
没有值啊
</c:if>
<!--注册的对话框-->
<div class="modal" id="myModal">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>对话框标题</h3>
	</div>
	<div class="modal-body">
	<form action="" method="POST" id="userRegister">
            <div>
                <input type="text" class="form-control" name="userName"  id="userName" placeholder="请输入用户名">
            </div>
            <div>
                <input type="password" class="form-control" name="userPassWord" id="userPassWord" placeholder="请输入密码">
            </div>
            <div>
                <input type="text"  class="form-control" name="userRePassWord" id="userRePassWord" placeholder="请再次输入密码">
            </div>

            <div>
                <input type="text" class="form-control" name="userEmail" id="userEmail" placeholder="请输入邮箱">
            </div>
            <div>
                <input type="text" class="form-control" name="userStudnum" id="userStudnum" placeholder="请输入学号">
            </div>
            <div>
                <input type="text" class="form-control" name="verifyCode" id="verifyCode" placeholder="请输入验证码">
            </div>

	</div>
	<div class="modal-footer">
		<a href="#" class="btn">关闭</a>
		<a href="#" class="btn btn-primary">保存更新</a>
	</div>
	</from>
</div>
<!-- 巨幕 -->
<div class="jumbotron">
	<h1>这里娶一个标题吧</h1>
	<p>后面慢慢想内容介绍吧，后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧</p>
	<p> <a class="btn btn-primary btn-large"> 了解更多请登录 </a> </p>
</div>

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
 /* $('#myModal').css({
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
  */
$('#myModal').modal({
	show:true,
	backdrop:false,
	keyboard:false
});
});
</script>
</html>