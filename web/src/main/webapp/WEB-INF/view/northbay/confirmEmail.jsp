<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/registration.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="container">
    <div class="row text">
        <h2>Email подтвержден</h2>
    </div>
    <div class="row text">
        <span>Перейти на <a href="${lang.context}">главную</a></span>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
