<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="<c:url value="${lang.resources}/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>Admin-categories</title>
    <
</head>
<body>
<div class="container">
    <div class="navbar navbar-inverse navbar-static-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="${lang.context}">Go to site ${lang.lang}</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">Orders</a></li>
                <li><a href="">Delivery</a></li>
                <li><a href="">Payment</a></li>
                <li><a href="">Categories</a></li>
                <li><a href="">Users</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <div class="page-header">
        <h1>Categories</h1>
    </div>
    <div class="row">
        <div class="navmenu navmenu-default navmenu-fixed-left col-xs-6 col-md-3">
            <a class="navmenu-brand visible-md visible-lg" href="${lang.context}/admin/categories?categoryId=0"><h2>Каталог</h2></a>
            <ul class="nav navmenu-nav">
                <li>
                    <span><a href="${lang.context}/admin/categories?categoryId=${category.parentId}">Назад</a></span>
                    <span class="badge"><a
                            href="${lang.context}/admin/categories/create?categoryId=${category.parentId}">+</a></span>
                </li>
                <c:forEach var="сategory" items="${categories}">
                    <li>
                        <span><a href="${lang.context}/admin/categories?categoryId=${сategory.id}">${сategory.name}</a></span>
                        <span class="badge"><a href="${lang.context}/admin/categories/create?categoryId=${сategory.id}">+</a></span>
                        <span class="badge"><a href="${lang.context}/admin/categories/delete?categoryId=${сategory.id}">-</a></span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-xs-6 col-md-9">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Товары категории</div>

                <!-- Table -->
                <table class="table">
                    ...
                </table>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
