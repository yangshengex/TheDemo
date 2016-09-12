<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<script src="resources/js/moment.js"></script>
<script src="resources/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form action="http://localhost:8080/mycloud/updateuser" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="username" class="col-md-2 control-label">姓名</label>
                    <div class="col-md-10">
                        <input type="text" name="name" class="form-control" id="username" placeholder="" value="${loginuser.name }">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-md-2 control-label">email</label>
                    <div class="col-md-10">
                        <input type="text" name="email" class="form-control" id="email" placeholder="" value="${loginuser.email }">
                    </div>
                </div>
                <div class="form-group">
                    <label for="male" class="col-md-2 control-label">性别</label>
                    <div class="col-md-10">
                        <div class="checkbox">
                            <label>
                                <input type="radio"  id="male" name="sex" placeholder="" ${loginuser.sex == true?'checked':'' } value="1"> 男
                            </label>
                            <label>
                                <input type="radio"  id="female" name="sex" placeholder="" ${loginuser.sex == true?'':'checked' } value="0"> 女
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birth" class="col-md-2 control-label">生日</label>
                    <div class="col-md-10">
                        <input type="text" name="birthday" class="form-control" id="birth" placeholder="" value="${loginuser.birthday }">
                        <script type="text/javascript">
                            $(function(){
                                $('#birth').datetimepicker({
                                    format:'YYYY-MM-DD HH:mm:ss',
                                    minDate:new Date(2007, 1 - 1, 1),//最小选择时间
                                    maxDate:new Date(2027, 1 - 1, 1)
                                })
                            });
                            /* 
                            maxDate : Date, Number, String : null 
 							 设置一个最大的可选日期。可以是Date对象，或者是数字（从今天算起，例如+7），
 							 或者有效的字符串('y'代表年, 'm'代表月, 'w'代表周, 'd'代表日, 例如：'+1m +7d')。 maxDate: '+1m +1w' 貌似不管用
                            */
                            
                        </script>
                    </div>
                </div>
                <div class="form-group">
                    <label for="des" class="col-md-2 control-label">个人简介</label>
                    <div class="col-md-10">
                        <textarea name="intro" class="form-control" id="des">${loginuser.intro }</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-9"></div>
                    <div class="col-md-3">
                        <button type="reset" class="btn btn-default">重置</button>
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
<script type="text/javascript">
$('#birth').blur(function(){alert($('#birth').val())})
</script>
</html>