<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/registration.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/menu.css"/>">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Вход в магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>

<div id="container">

    <form:form commandName="user" method="post" action="${lang.context}/user/login">
        <div class="row">
            <div>Email:</div>
            <form:input path="email"/>
        </div>
        <div class="row">
            <div>Пароль:</div>
            <form:password path="pwd"/>
        </div>
        <div class="row">
            <input type="submit" value="Войти"/>
        </div>
        <c:if test="${not empty error}">
            <div class="row">
                <div class="error">
                    <span>Неправильный email или пароль. Если Вы забыли пароль, Вы можете <a>восстановить</a> его</span>
                </div>
            </div>
        </c:if>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
