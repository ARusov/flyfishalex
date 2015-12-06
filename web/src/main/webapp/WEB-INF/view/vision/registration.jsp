<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/global.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/header.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/registration.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/menu.css"/>">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/registration.js"/>"></script>
    <title>Регистрация</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>

<div id="container">

    <form:form commandName="user" method="post" action="${lang.context}/user/registration">
        <div class="row">
            <div>Ваше имя:</div>
            <form:input path="name"/>
        </div>
        <div class="row">
            <div>Email:</div>
            <form:input path="email"/>
        </div>
        <div class="row">
            <div>Пароль:</div>
            <form:password path="pwd"/>
        </div>
        <div class="row">
            <div>Повторите пароль:</div>
            <input type="password" id="repeatPwd"/>
        </div>
        <div class="row">
            <input id="button" type="submit" value="Регистрация"/>
        </div>
        <c:if test="${not empty error}">
            <div class="row">
                <div class="error"><span>Вы уже зарегистрированы на на нашем сайте. Вы можете <a
                        href="${lang.context}/user/login">войти</a> на сайт или <a>восстановить пароль</a></span></div>
            </div>
        </c:if>
    </form:form>
</div>
</body>
</html>
