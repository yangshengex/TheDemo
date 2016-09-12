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
<div class="container">
    <div class="row">
        <div class="col-md-2" ></div>
        <div class="col-md-8" >
            <!-- 表格 -->
            <table class="table table-striped table-bordered table-hover table-condensed">
                <tr>
                    <td>编号</td>
                    <td>文件名</td>
                    <td>文件大小</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${myfiles }" var="f">
                	<tr>
	                    <td>${f.id }</td>
	                    <td>${f.name }</td>
	                    <td>${f.size }</td>
	                    <td><a href="/mycloud/download?id=${f.id }" class="btn btn-primary">下载</a> <a href="/mycloud/share?id=${f.id }" class="btn btn-success">共享</a> <a href="" class="btn btn-danger">删除</a></td>
                	</tr>
                </c:forEach>
                
            </table>
            <!-- 分页 -->
            <nav>
                <ul class="pager">
                    <li><a href="#">第一页</a></li>
                    <li><a href="#">上一页</a></li>
                    <li><a href="#">下一页</a></li>
                    <li><a href="#">最末页</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-2" ></div>
    </div>
</div>
</body>
</html>