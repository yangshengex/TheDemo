$('#addbook').click(function(){
    $('#addBook_model').modal({
           show:true,
           backdrop:'static',
           keyboard:false
         });

});
$('#addbook_submit').click(function(){
    var formData = $('#addbook_form').serializeArray();
           var fordataJSOM ={};//定义一个对象
           var JSONval;//接收对象转化的json数据
           $.each(formData,function(){
           if(this.name!="book_cover"){
            fordataJSOM[this.name] = this.value;//为这个对象增加属性和值
            }
           });
           JSONval = JSON.stringify(fordataJSOM);
            //alert(JSON.stringify(fordataJSOM));
            $.ajax({
                url:'/TheDemo/books/addbook',
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


});