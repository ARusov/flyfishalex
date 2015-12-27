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
        <h1>Categories-Create</h1>
    </div>

    <div>
        <form:form method="post" commandName="category"
                   action="${lang.context}/admin/category">
            <p>Идентификатор в базе данных: <form:input path="id"/></p>

            <p>Российское наименование: <form:input path="name"/></p>

            <p>Родительская категория: <form:input path="parentId"/><span id="parentName">${parentCategory.name}</span> <a
                    id="selectCategory">...</a>
            </p>

            <form:checkboxes path="stores" items="${stores}" itemValue="id" itemLabel="lang"/>

            <p>Вендор <form:input path="vendorId"/></p>

            <input type="submit" value="Изменить/Добавить"/>
            <input id="deleteCatogory" type="button" value="Удалить"/>
        </form:form>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
