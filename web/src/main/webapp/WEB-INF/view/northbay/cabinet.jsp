<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Личный кабинет</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <jsp:include page="cabinetMenu.jsp"/>
    <div class="row">
        <c:if test="${not empty user}">
            <form name="user" class="form-signin" role="form" method="post" action="${lang.context}/user/cabinet">
                <h2 class="form-signin-heading">Личные данные:</h2>
                <input name="id" type="hidden" value="${user.id}">
                <input name="name" type="text" class="form-control" placeholder="Имя" required="" autofocus="" value="${user.name}">
                <input name="email" type="email" class="form-control" placeholder="Email address" required="" autofocus="" value="${user.email}">
                <input name="pwd" type="password" class="form-control" placeholder="Password" required="" value="${user.pwd}">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">Вы уже зарегистрированы на на нашем сайте. Вы можете <a
                            href="${lang.context}/user/login">войти</a> на сайт или <a>восстановить пароль</a>
                    </div>
                </c:if>
                <h2 class="form-signin-heading">Ваш адрес доставки:</h2>
                <input name="address.zip" type="text" class="form-control" placeholder="Индекс" autofocus="" value="${user.address.zip}">
                <input name="address.country" type="text" class="form-control" placeholder="Страна"  autofocus="" value="${user.address.country}">
                <input name="address.region" type="text" class="form-control" placeholder="Область / регион"  autofocus="" value="${user.address.region}">
                <input name="address.city" type="text" class="form-control" placeholder="Город"  autofocus="" value="${user.address.city}">
                <input name="address.street" type="text" class="form-control" placeholder="Улица"  autofocus="" value="${user.address.street}">
                <input name="address.building" type="text" class="form-control" placeholder="Здание / дом"  autofocus="" value="${user.address.building}">
                <input name="address.flat" type="text" class="form-control" placeholder="Квартира"  autofocus="" value="${user.address.flat}">
                <input name="address.tel" type="text" class="form-control" placeholder="Телефон"  autofocus="" value="${user.address.tel}">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Изменить</button>
            </form>
        </c:if>
    </div>
<jsp:include page="footer.jsp"/>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
