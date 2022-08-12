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
                    <label for="price">商品价格:</label>
                    <input type="text" class="form-control" id="price" name="price" value="${p.price}" />
                    <label for="stock">商品库存:</label>
                    <input type="text" class="form-control" id="stock" name="stock" value="${p.stock}" />
                    <input type="hidden" class="form-control" id="cid" name="cid" value="${p.cid}" />
                </div>
            <button type="submit" class="btn btn-default">新增</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
