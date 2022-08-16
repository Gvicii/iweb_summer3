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
            <form role="form" action="updateProduct" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" value="${p.id}" />
                    <label for="name">商品名称:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${p.name}" />
                    <label for="subTitle">商品小标题:</label>
                    <input type="text" class="form-control" id="subTitle" name="subTitle" value="${p.subTitle}" />
                    <label for="originalPrice">商品原价:</label>
                    <input type="text" class="form-control" id="originalPrice" name="originalPrice" value="${p.originalPrice}" />
                    <label for="promotePrice">商品优惠价:</label>
                    <input type="text" class="form-control" id="promotePrice" name="promotePrice"
                    value="${p.promotePrice}"/>
                    <label for="stock">商品库存:</label>
                    <input type="text" class="form-control" id="stock" name="stock" value="${p.stock}" />
                    <input type="hidden" class="form-control" id="cid" name="cid" value="${p.category.id}" />
                </div>
            <button type="submit" class="btn btn-default">新增</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
