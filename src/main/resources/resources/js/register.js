/**
 * Created by Administrator on 2018/10/27.
 */
$(function () {
    $("#regForm").validate({
        onsubmit:true,// 是否在提交是验证
        onkeyup: false,
        //失去焦点验证
        onfocusout:function(element){ $(element).valid();},// 是否在获取焦点时验证
        rules: {　　　　
            username: {　　
                required: true,
                minlength: 7,
                maxlength: 16 ,
                remote: {
                    type: "post",
                    url: "/nameverify",
                    data: {
                        username: function() {
                            return $("#username").val();
                        }
                        // 如果直接写“data: {username: $("#username").val();}”，这样是获取不到值的。
                    },
                    dataType: "json",
                        dataFilter: function(data) {
                            return data;
                        }
                }
            },
            password: {
                required: true,
                minlength: 7,
                maxlength: 16
            },
            secondPassword:{
                required: true ,
                equalTo: "#password"
            }
        },
        messages:{　　　　//验证错误信息
            username: {
                required: "请输入用户名" ,
                minlength: "至少7位字符" ,
                maxlength: "最多16位字符" ,
                remote: "用户名已存在"
            },
            password: {
                required: "请输入密码",
                minlength: "至少7位字符" ,
                maxlength: "最多16位字符"
            },
            secondPassword:{
                required: "请确认密码" ,
                equalTo: "密码不一致"
            }
        },
    });

});