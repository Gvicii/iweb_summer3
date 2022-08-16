<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="../include/header.jsp" />
<script>
    $(function () {
        $('.deleteBtn').click(function () {
        //         获取id
            let id = $(this).attr("id");
            //设置请求url
            let url = "deleteProperty?id="+id;
            //传递节点的引用 这里$(this)指代的是触发点击事件的当前按钮
            let this_ = $(this);
            $.get(
                url,
                function (data) {
                    //根据后端的响应结果 判断删除是否成功！
                    if(data=="success"){
                        this_.parent().parent().hide();
                    }else{
                        alert("删除失败,请刷新页面！");
                    }
                }
            )
        });
    });

</script>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    属性管理界面 <small>你猜猜我是干嘛的？知道还问</small>
                </h1>
            </div>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>
                        属性id
                    </th>
                    <th>
                        属性名称
                    </th>
                    <th>
                        编辑
                    </th>
                    <th>
                        删除
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${properties}" var="p" varStatus="st">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td><a href="editProperty?id=${p.id}"><button type="button" class="btn btn-default btn-primary">编辑</button></a> </td>
                        <td><button type="button" id="${p.id}" class="deleteBtn btn btn-default btn-danger">删除</button> </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
            <form role="form" action="addProperty">
                <div class="form-group">
                    <label for="name">属性名称:</label>
                    <input type="text" class="form-control" id="name" name="name" />

                    <input  type="hidden" class="form-control" id="cid" name="cid" value="${cid}" />
                </div>
                <button type="submit" class="btn btn-default">增加</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
