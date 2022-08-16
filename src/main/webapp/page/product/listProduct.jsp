<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        商品图片
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                       商品小标题
                    </th>
                    <th>
                        商品原价
                    </th>
                    <th>
                        商品优惠价
                    </th>
                    <th>
                        库存
                    </th>
                    <th>
                        商品创建时间
                    </th>
                    <th>
                        编辑
                    </th>
                    <th>
                        删除
                    </th>
                    <th>
                        图片管理
                    </th>
                    <th>
                        属性值设置
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product" varStatus="st">
                    <tr>
                        <td>

                            <c:if test="${empty product.images}">
                            <img width="100px" height="100px" src="http://39.106.106.39:8888/voice/20220815144248_lyq.jpg" class="img-thumbnail" /></td>

                    </c:if>
                            <c:if test="${!empty product.images}">
                            <img width="100px" height="100px" src="${product.images.get(0).url}" class="img-thumbnail" /></td>
                            </c:if>
                        <td>${product.name}</td>
                        <td>${product.subTitle}</td>
                        <td>${product.originalPrice}</td>
                        <td>${product.promotePrice}</td>
                        <td>${product.stock}</td>
                        <td>${product.createDate}</td>
                        <td><a href="editProduct?id=${product.id}"><button type="button" class="btn btn-default btn-primary">编辑</button></a> </td>
                        <td><a href="deleteProduct?id=${product.id}"><button type="button" class="btn btn-default btn-danger">删除</button></a> </td>
                        <td><a href="listImg?id=${product.id}"><span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span></a> </td>
                        <td><a href="setPropertyValue?id=${product.id}"><span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span></a> </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
            <form role="form" action="addProduct">
                <div class="form-group">
                    <label for="name">商品名称:</label>
                    <input type="text" class="form-control" id="name" name="name" />
                    <label for="subTitle">商品小标题:</label>
                    <input type="text" class="form-control" id="subTitle" name="subTitle" />
                    <label for="originalPrice">商品原价:</label>
                    <input type="text" class="form-control" id="originalPrice" name="originalPrice" />
                    <label for="promotePrice">商品优惠价:</label>
                    <input type="text" class="form-control" id="promotePrice" name="promotePrice" />
                    <label for="stock">商品库存:</label>
                    <input type="text" class="form-control" id="stock" name="stock" />

                    <input  type="hidden" class="form-control" id="cid" name="cid" value="${cid}" />
                </div>
                <button type="submit" class="btn btn-default">增加</button>
            </form>
<%--            --%>
        </div>
    </div>
</div>
</body>
</html>
