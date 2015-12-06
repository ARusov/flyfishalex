<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/global.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/header.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/article.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/vision/menu.css"/>">
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/registration.js"/>"></script>
    <title>Оплата Vision Fishing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>

<div id="container">
    <p>&nbsp;Оплата
    <ul>
        <li> Оплата наличными при вручении заказа курьером или в нашем пункте выдачи</li>
        <li>Банковскими картами Visa и MasterCard.</li>
        <li>Сбербанк Online</li>
        <li>Яндекс-Деньги1</li>
    </ul>
    </p>

    <p>&nbsp;Способы оплаты постоянно обновляются, для более точной информации Вы можете обратиться к нашим
        менеджерам</p>

    <p>&nbsp;Ждем Вас в нашем интернет магазине</p>

    <p>&nbsp;Всегда к Вашим услугам, коллектив нахлыстового интернет магазина <a href="http://visionfishing.ru/">Vision
        Fishing</a>!</p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
