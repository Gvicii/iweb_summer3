<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2022/8/12
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp" />
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    商品管理界面 <small>除了CRUD还有其他图片上传 属性管理</small>
                </h1>
            </div>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>
                        商品id
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品价格
                    </th>
                    <th>
                        商品库存
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
                <c:forEach items="${products}" var="product" varStatus="st">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.stock}</td>
                        <td><a href="editProduct?id=${product.id}"><button type="button" class="btn btn-default btn-primary">编辑</button></a> </td>
                        <td><a href="deleteProduct?id=${product.id}"><button type="button" class="btn btn-default btn-danger">删除</button></a> </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <form role="form" action="addProduct">
                <div class="form-group">
                    <label for="name">商品名称:</label>
                    <input type="text" class="form-control" id="name" name="name" />
                    <label for="price">商品价格:</label>
                    <input type="text" class="form-control" id="price" name="price" />
                    <label for="stock">商品库存:</label>
                    <input type="text" class="form-control" id="stock" name="stock" />
                    <input  type="hidden" class="form-control" id="cid" name="cid" value="${cid}" />
                </div>
                <button type="submit" class="btn btn-default">增加</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
