<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--引入所需资源-->
<jsp:include page="./resources/common/head.jsp"></jsp:include>
</head>
<body >

<h1>${some}</h1>
<h1>${user.username}</h1>

<!--注册的对话框-->
<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-md" role="document">
            <form id="userRegister" method="post"  action="wwww.baidu.com">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title text-center" id="myModalLabel"><b>注册用户</b></h4>
        </div>
        <div class="modal-body">
          <div class="form-group  ">
            <input type="text" name="userName" class="form-control " id="userName" placeholder="用户名称"/>
          </div>
          <div class="form-group ">
            <input type="password" name="userPassWord" class="form-control" id="userPassWord" placeholder="用户密码"/>
          </div>
          <div class="form-group ">
            <input type="password" name="userRePassWord" class="form-control" id="userRePassWord" placeholder="重复密码"/>
          </div>
            <div class="form-group ">
              <input type="text" name="userEmail" class="form-control" id="userEmail" placeholder="邮箱"/>
            </div>
          <div class="form-group">
            <input type="text" name="verifyvalue" class=" form-control col-md-5 col-offset-2 input" id="verifyvalue" placeholder="验证码"/>
            <img id="verifycode"src="${pageContext.request.contextPath}/getverifycode" class"col-md-3 "><a herf="#" class="btn" id="vimg">看不清</a>
          </div>
        </div>
        <div class="modal-footer ">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button type="submit" id="btn_submit" class="btn btn-primary" ><span class="glyphicon glyphicon-floppy-disk" ></span>保存</button>
        </div>
      </div>
      </from>
    </div>
  </div>
  <!--/注册对话框结束-->


<!-- 巨幕 -->
<div class="jumbotron" >
<div  style="margin-left:100px;margin-right:100px">
	<h1>这里娶一个标题吧</h1>
	<pre>
	后面慢慢想内容介绍吧，后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢绍吧后面慢慢想内容介绍吧后面慢慢想内容
	介绍吧后面慢慢想内容介绍吧后面慢慢绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧后面慢慢绍吧后面慢慢想内容介绍吧后面慢慢想
	内容介绍吧后面慢慢想内容介绍吧后面慢慢想内容介绍吧
	</pre>
	<p>没有账号，赶紧注册吧!</p> <a class="btn btn-primary btn-large right"id="RegisterDialog"> 注册了解更多 </a>
	</div>
</div>
<!-- /巨幕 -->
<button type="button" class="btn btn-primary" title="Popover title" data-container="body" data-toggle="popover"  data-trigger="focus" data-content="顶部的 Popover 中的一些内容">
顶部的 Popover
</button>

<h1 id="medialog" class="btn btn-info">点击弹出对话框</h1>
<c:if test="${errormessages!=null}">

<div class="modal fade" id="errModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-md" role="document">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button> 
          <h4 class="modal-title text-center"  id="myModalLabel">${errormessages}</h4>
        </div>
    </div>
  </div>
 </div>
 </c:if>

<hr>
<hr>
 <% request.getSession().removeAttribute("errormessages");%>
<script src="./resources/js/jquery.validate.js"></script>
<script src="./resources/myJS/registervaridata.js"></script>
<script>
</script>
</body>
</html>