/**
 * Created by Administrator on 2018/10/25.
 */
$(function () {
    $.getJSON("/getCate", function (json) {
        alert(json[0].productCategoryName);
        for (var i = 0; i < json.length; i++) {
            $("#tab").append("<tr><td>" + json[i].productCategoryId + "</td> " +
                "<td>" + json[i].productCategoryName + "</td> <td>" + json[i].priority + "</td>" +
                " <td>" + new Date(json[i].createTime).toLocaleString() + "</td> <td>" + json[i].parent.productCategoryId + "</td> </tr>");
        }
    });
});