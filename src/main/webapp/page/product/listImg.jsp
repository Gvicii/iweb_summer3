<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2022/8/15
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false"
%>
<jsp:include page="../include/header.jsp"/>
<html>
<head>
    <title>Title</title>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <%--                可以传递商品对象过来 将图片集合绑定在这个商品里就可以了--%>

                <c:forEach items="${p.images}" var="i" varStatus="st">
                    <tr>
                        <td><img width="100px" height="100px" src="${i.url}" class="img-thumbnail"/></td>
                        <td>${p.name}</td>
                        <td><a href="deleteImg?id=${i.id}&pid=${p.id}">
                            <button type="button" class="btn btn-default btn-danger">删除</button>
                        </a></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="3">
                        <form role="form" action="addImg" method="post">
                            <div class="form-group">
                                <label for="url"></label>
                                <input type="text" class="form-control" id="url" name="url"/>
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" id="pid" name="pid" value="${p.id}"/>
                            </div>
                            <button type="submit" class="btn btn-default">提交</button>
                        </form>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
