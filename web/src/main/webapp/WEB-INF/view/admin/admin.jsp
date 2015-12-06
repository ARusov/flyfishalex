<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="container">
    <ul id="admin-menu">
        <%--<li><a href="${lang.context}/admin/categories">Категории</a></li>--%>
        <li><a href="${lang.context}/admin/products">Товары</a></li>
        <li><a href="${lang.context}/admin/users">Пользователи</a></li>
        <li><a href="${lang.context}/admin/orders/delivery">Доставка</a></li>
        <li><a href="${lang.context}/admin/orders/payment">Оплата</a></li>
        <li><a href="${lang.context}/admin/orders">Заказы</a></li>
    </ul>
</div>
</body>
</html>
