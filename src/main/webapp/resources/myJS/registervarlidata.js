/*
 *使用jquery空提交事件，防止刷新时提示重复提交表单
 */
 $('#Loginbtn').click(function(){
    $('#Loginbtnform').submit();
 });

$('#RegisterDialog').click(function(){
//动态给出弹出位置
    $('#myModal').css({
        'width':400,
        'top': function () {
            //$(window).height()浏览器高度,然后减去自己的高度/2,实现弹出层垂直居中
//            alert($(window).height());
//            alert($(document).height());
            return 100;

        } ,
        'left':function(){
//        	 alert($('#myModal').width())
//        	  alert($('#myModal').width())
        	 return ($(document).width()-$('#myModal').width())/2;
        }
    });
	/**
     * 弹出对话框
     */
    $('#myModal').modal({
    	show:true,
    	backdrop:'static',
    	keyboard:false
    });
});
/**
 * 验证表单数据
 */

    $( "#userRegister" ).validate( {
    submitHandler: function(form){
       var formData = $('#userRegister').serializeArray();
       var fordataJSOM ={};//定义一个对象
       var JSONval;//接收对象转化的json数据
       $.each(formData,function(){
        fordataJSOM[this.name] = this.value;//为这个对象增加属性和值
       });
       JSONval = JSON.stringify(fordataJSOM);
        //alert(JSON.stringify(fordataJSOM));
        $.ajax({
            url:'userRegister',
            dataType:'json',
            type:'post',
            data:JSONval,
            contentType:"application/json",
            success:function(res){
                alert('成功'+res);
            },
            error:function(res){
                alert('失败'+res);
            }

        });
    },
    /*
    下面的虽然是 boolean 型的，但建议除非要改为 false，否则别乱添加。
    触发方式 类型 描述 默认值
    onsubmit Boolean 提交时验证。设置为 false 就用其他方法去验证。 true
    onfocusout Boolean 失去焦点时验证（不包括复选框/单选按钮）。 true
    onkeyup Boolean 在 keyup 时验证。 true
    onclick Boolean 在点击复选框和单选按钮时验证。 true
    focusInvalid Boolean 提交表单后，未通过验证的表单（第一个或提交之前获得焦点的未通过验证的表单）会获得焦点。 true
    focusCleanup Boolean 如果是 true 那么当未通过验证的元素获得焦点时，移除错误提示。避免和 focusInvalid 一起用。 false
    */
    rules: {
        stu_num:{
        required:true,
        digits:true,
        minlength:10,
        maxlength:11
        },
        stu_name: {
            required: true,
            minlength: 2,
            maxlength:10
        },
        stu_pwd: {
            required: true,
            minlength: 5
        },
        stu_repwd: {
            required: true,
            minlength: 5,
            equalTo: "#stu_pwd"
        },
        stu_email:{
            required:true,
            email:true
        },
        verifyvalue:{

           // required:true,
                    remote : {
                        url : "beginverify",
                        type : "post",
                        dataType : "json",
                        data : {
                            pwd : function() {
                                return $("#verifyCode").val();// 这个是取要验证的密码
                            }
                        },
                        dataFilter : function(data) {// 判断控制器返回的内容
                            if (data == "true") {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            },
    messages: {
        stu_num:{
            required:"Please enter a stu_num",
            digits:'Please enter digits',
            minlength: "Your username must consist of at least 10 characters",
            maxlength: "Your username must consist of at largest 11 characters"
        },
        stu_name: {
            required: "Please enter a username",
            minlength: "Your username must consist of at least 2 characters",
            maxlength: "Your username must consist of at largest 10 characters"
        },
        stu_pwd: {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long"
        },
        stu_repwd: {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long",
            equalTo: "Please enter the same password as above"
        },
        stu_email:{
            required: "Please provide a email",
            email:"your email must is valid"
        },
        verifyvalue:"验证不通过"
    },
    errorElement: "em",
    errorPlacement: function ( error, element ) {
        // Add the `help-block` class to the error element
        error.addClass( "help-block" );
        //找到错误的以有class为form-group的父级元素
        element.parents( ".form-group" ).addClass( "has-feedback" );
        //需要对checkBox进行单独处理
        if ( element.prop( "type" ) === "checkbox" ) {
            //错误时在checkbox的那个div上插入元素
            error.insertAfter( element.parents( "label" ) );
        } else {
            error.insertAfter( element );
        }
        // Add the span element, if doesn't exists, and apply the icon classes to it.
        if ( !element.next( "span" )[ 0 ] ) {
            $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
        }
    },
    success: function ( label, element ) {
        // Add the span element, if doesn't exists, and apply the icon classes to it.
        if ( !$( element ).next( "span" )[ 0 ] ) {
            $( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
        }
    },
    highlight: function ( element, errorClass, validClass ) {
        $( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
        $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );//修改span的图标
    },
    unhighlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
                    $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
    }
  });

  /**
   * 得到验证码
   */
  $('#vimg').click(function(){
  	$('#verifycode').attr("src", "/TheDemo/user/getverifycode?t=" + Math.random());
  });