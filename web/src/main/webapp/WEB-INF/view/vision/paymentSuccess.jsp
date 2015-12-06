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
    <title>Спасибо за оплату заказа</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div class="row text">
        <h2>Спасибо за оплату товара</h2>
    </div>
    <div class="row text">
        <span><p>Наши менеджеры в ближайшее время отправят Ваш заказ. Изменения о статусе заказы Вы можете увижеть в
            личном кабете и в оповещениях по электронной почте</p></span>
    </div>
    <div class="row text">
        <span><p>Перейти в <a href="${lang.context}/user/cabinet">личный кабинет</a></p></span>
    </div>
    <div class="row text">
        <span>Перейти на <a href="${lang.context}">главную</a></span>
    </div>
</div>
</body>
</html>

