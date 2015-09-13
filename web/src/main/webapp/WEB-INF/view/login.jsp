<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/registration.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="${lang.lang}/header.jsp"/>

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
</body>
</html>
