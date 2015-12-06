<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/cabinet.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/menu.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/footer.css"/> ">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/cabinet.js"/>"></script>
    <title>Личный кабинет</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <div id="form">
        <form:form commandName="user" method="post" action="${lang.context}/user/cabinet">
            <form:hidden path="id"/>
            <div class="row">
                <div>Ваше имя:</div>
                <form:input path="name"/>
            </div>
            <div class="row">
                <div>Email:</div>
                <form:input path="email" disabled="true"/>
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
                <div>Ваш адрес доставки</div>
            </div>
            <div class="row">
                <div>Индекс:</div>
                <form:input path="address.zip"/>
            </div>
            <div class="row">
                <div>Страна:</div>
                <form:input path="address.country"/>
            </div>
            <div class="row">
                <div>Регион:</div>
                <form:input path="address.region"/>
            </div>
            <div class="row">
                <div>Город:</div>
                <form:input path="address.city"/>
            </div>
            <div class="row">
                <div>Улица:</div>
                <form:input path="address.street"/>
            </div>
            <div class="row">
                <div>Здание:</div>
                <form:input path="address.building"/>
            </div>
            <div class="row">
                <div>Квартира:</div>
                <form:input path="address.flat"/>
            </div>
            <div class="row">
                <div>Телефон:</div>
                <form:input path="address.tel"/>
            </div>

            <div class="row">
                <input id="button" type="submit" value="Изменить"/>
            </div>
            <c:if test="${not empty error}">
                <div class="row">
                    <div class="error"><span>Вы уже зарегистрированы на на нашем сайте. Вы можете <a
                            href="${lang.context}/user/login">войти</a> на сайт или <a>восстановить пароль</a></span>
                    </div>
                </div>
            </c:if>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
