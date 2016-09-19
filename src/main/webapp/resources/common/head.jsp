<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--引入所需资源-->
<jsp:include page="./header.jsp"></jsp:include>
</head>
<body>
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
            <a class="navbar-brand" href="#">欢迎使用Web图书馆</a>
           <c:if test="${user.stu_name!=null}"> <a class="navbar-brand  primary" href="#">用户 ： ${user.stu_name} </a></c:if>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <c:if test = "${user.stu_name!=null}">
            <ul class="nav navbar-nav">
                <li class="active"><a href="indexController"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页 <span class="sr-only">(current)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" >我的图书<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a  target="main">
                                <a  href="#" rel="tooltip" data-placement="left"  title="查询你已经借的书籍">已借书籍</a>
                             </a>
                        </li>
                        <li><a  target="main">
                               <a href="#" rel="tooltip" data-placement="left"  title="查询你关注书籍的信息">关注书籍</a>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">图书馆<span class="badge">50</span><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    <c:choose>
                        <c:when test="${user.type==1}">
                         <li><a href="#">增加图书</a></li>
                         <li><a href="#">删除图书<span class="badge">50</span></a></li>
                         <li><a href="#">修改图书</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="#">去借书</a></li>
                        <li><a href="#">去还书 <span class="badge">50</span></a></li>
                        <li><a href="#">关注书籍</a></li>
                        <li><a href="#">请求意向</a></li>
                         </c:otherwise>
                    </c:choose>
                    </ul>
                </li>
            </ul>
            </c:if>
        <c:choose>
            <c:when test = "${user.stu_name==null}">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <form id="Loginbtnform" target="_parent" class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath }/user/UserLogin" method="post">
                        <input type="hidden"  name="token" value="${token}">
                        <div class="form-group">
                            <input type="text" class="form-control" name="username" autofocus required placeholder="请输入账号（学号）">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="userpassword" required placeholder="请输入密码">
                        </div>
                        <button type="button" id="Loginbtn" class="btn btn-info">登录</button>
                  </form>
            </div><!-- /.navbar-collapse -->
            </c:when>
             <c:otherwise>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                      <form target="_parent" class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath }/user/out_Login" method="post">
                                <button type="submit" class="btn btn-info">退出</button>
                      </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
</body>
</html>