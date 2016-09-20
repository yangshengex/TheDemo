<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<head>
<!--引入所需资源 这里因为head.jsp中已经有了资源文件，所以我们就不用再引入了 不然一些js操作不能执行-->

</head>
<body >
<jsp:include flush="false" page="/resources/common/head.jsp"></jsp:include>
<!-- 巨幕 -->
<div class="jumbotron">
	<h1>这里是LoginedUI的界面</h1>
	<p>登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面登入界面</p>
	<p> <a class="btn btn-primary btn-large"> ... </a> </p>
</div>
<div class="modal fade " id="addBook_model" tabindex="-1" role="dialog" >
    <div class="modal-dialog" role="document">
          <form role="form" id="addbook_form" class="form-horizontal" action="${pageContext.request.contextPath }/books/addbook" method="post" enctype="multipart/form-data" >
          <input type="hidden" name="token" value="${token}">
               <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title text-center" id="myModalLabel"><b>添加图书</b></h4>
                  </div>
               <div class="modal-body">
          <div class="form-group">
            <label class="col-sm-3 control-label" for="book_name">图书名称</label>
            <div class="col-sm-7">
            <input type="text" class="form-control" name="book_name" id="book_name" placeholder="图书名称">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label" for="book_type">图书分类</label>
            <div class="col-sm-7">
                <select class="form-control" id="book_type" name="type">
                  <option value="历史">历史</option>
                  <option value="科技">科技</option>
                  <option value="散文">散文</option>
                  <option value="小说">小说</option>
                  <option value="实事">实事</option>
                </select>
                </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label"  for="book_price">图书价格</label>
            <div class="col-sm-7">
            <input type="text" name="price" class="form-control" id="book_price"  placeholder="图书价格(保留小数点后两位)">
            </div>
          </div>
           <div class="form-group">
             <label class="col-sm-3 control-label"  for="book_content">图书简介</label>
             <div class="col-sm-7">
             <textarea class="form-control" id="book_content" name="content" rows="3"></textarea>
             </div>
           </div>
           <div class="form-group">
             <label class="col-sm-3 control-label"  for="book_cover">图书封面</label>
             <div class="col-sm-7">
             <input type="file" class="form-control" name="book_cover" id="book_cover"  placeholder="图书封面">
             </div>
           </div>
          <div class="modal-footer ">
             <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
             <button type="submit" id="adbook_submit" class="btn btn-primary" ><span class="glyphicon glyphicon-floppy-disk" ></span>保存</button>
           </div>
          </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath }/resources/myJS/libraryJS.js"></script>
<script>
$("[rel='tooltip']").tooltip();

</script>
</body>
</html>