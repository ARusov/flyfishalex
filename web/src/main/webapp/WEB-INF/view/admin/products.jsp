<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
<link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/admin/products.css"/> ">
<head>
    <title></title>
</head>
<body>
<div id="container">

    <table border="1">
        <tr class="product-row">
            <th class="product-id">Id</th>
            <th class="product-name">Наименование</th>
            <th class="product-nameEn">Наименование англ</th>
            <th class="product-category">Категория</th>
            <th class="product-provider">Поставщик</th>
            <th class="product-edit"><a href="${lang.context}/admin/products/product">New</a></th>
            <th class="product-delete"></th>
        </tr>
        <c:if test="${not empty products}">
            <c:forEach items="${products}" var="product">
                <tr class="product-row">
                    <td class="product-id">${product.id}</td>
                    <td class="product-name">${product.name}</td>
                    <td class="product-nameEn">${product.nameEn}</td>
                    <td class="product-category">${product.categoryId}</td>
                    <td class="product-provider">${product.provider}</td>
                    <td class="product-edit"><a href="${lang.context}/admin/products/product/${product.id}">Edit</a>
                    </td>
                    <td class="product-delete"><a href="${lang.context}/admin/products/product/delete/${product.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2" align="right"><c:if test="${page >0}">
                    <a href="${lang.context}/admin/products?p=${page-1}">Назад</a>
                </c:if></td>
                <td> <a href="${lang.context}/admin/products?p=${page+1}">Далее</a></td>
            </tr>
        </c:if>
    </table>
</div>
</body>
</html>
