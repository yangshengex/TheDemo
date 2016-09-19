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
<script>
$("[rel='tooltip']").tooltip();
</script>
</body>
</html>