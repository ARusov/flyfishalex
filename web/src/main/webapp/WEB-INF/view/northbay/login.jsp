<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Вход в магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <form name="user" class="form-signin" role="form" method="post" action="${lang.context}/user/login">
        <h2 class="form-signin-heading">Введите логин и пароль:</h2>
        <input name="email" type="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <input name="pwd" type="password" class="form-control" placeholder="Password" required="">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">Неправильный email или пароль. Если Вы забыли пароль, Вы можете <a>восстановить</a>
                его
            </div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
