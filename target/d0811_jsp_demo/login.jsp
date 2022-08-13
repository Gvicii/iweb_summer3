<%--
  Created by IntelliJ IDEA.
  User: GUAN
  Date: 2022/8/13
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="page/include/header.jsp" />
<html>
<head>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-image: url("imgs/back.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
            min-height: 100vh;

        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="../assets/ico/favicon.png">
    <title>Title</title>
</head>
<body>
<div class="container">

    <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">欢迎来到尊贵的简陋后台系统</h2>
        <input type="text" class="input-block-level" placeholder="用户名" name="username">
        <input type="password" class="input-block-level" placeholder="密码" name="password">
        <button class="btn btn-large btn-primary" type="submit">登录</button>
    </form>

</div>

</body>
</html>
