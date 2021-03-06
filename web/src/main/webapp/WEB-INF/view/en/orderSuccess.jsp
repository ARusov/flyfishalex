<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/registration.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="container">
   <h2>Спасибо за заказ</h2>
    <p>Перейти в <a href="${lang.context}/user/cabinet/orders">мои заказы</a></p>
    <p>Перейти на <a href="${lang.context}">главную</a></p>
</div>
</body>
</html>
