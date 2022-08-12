<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2022/8/12
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="../include/header.jsp" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="updateCategory" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" value="${category.id}" />
                    <label for="name">分类名称:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${category.name}" />
                </div>
            <button type="submit" class="btn btn-default">新增</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
