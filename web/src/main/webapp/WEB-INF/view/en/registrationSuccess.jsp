<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/registration.css"/>">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/menu.css"/>">

    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/registration.js"/>"></script>

    <title>Спасибо за регистрацию</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div class="row text">
        <h2>Спасибо за регистрацию</h2>
    </div>
    <div class="row text">
        <span>Мы отправли Вам письмо на электронную почту, которую Вы указали при регистрации. Для подтверждения регистрации перейдите по ссылке, указанной в письме</span>
    </div>
    <div class="row text">
        <span>Перейти на <a href="${lang.context}">главную</a></span>
    </div>
</div>
</body>
</html>
