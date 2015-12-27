<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Интернет-магазин Northbay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <div class="page-header">
        <h2>Оплата заказа ${orderId}</h2>
    </div>
    <div class="row">
    <form class="form-signin"  role="form" name="ShopForm" method="POST" action="https://money.yandex.ru/eshop.xml">

        <font face="tahoma" size="2"/>

        <input class="form-control" type="hidden" name="shopId" value="48026">

        <input type="hidden" name="scid" value="39863">

        <%--Идентификатор пользователя:<br>--%>

        <input class="form-control" type=hidden name="CustomerNumber" size="64" value="${userId}">
        <h2 class="form-signin-heading">Сумма (руб.):</h2>
        <input class="form-control" type=text name="sum" size="64" value="${price}"><br><br>


        <input name="orderNumber" class="form-control" value="${orderId}" type="hidden"/>

        <input name="shopSuccessURL" class="form-control" value="${lang.context}/paymentSuccess" type="hidden"/>

        <input name="shopFailURL" class="form-control" value="${lang.context}/paymentFail" type="hidden"/>

        <h2 class="form-signin-heading">Способ оплаты:</h2>

        <label class="radio-inline"><input name="paymentType" value="PC" type="radio" checked="checked"/>Со счета в Яндекс.Деньгах (яндекс
        кошелек)</label><br/>

        <label class="radio-inline"><input  name="paymentType" value="AC" type="radio">С банковской карты</label><br/>

        <label class="radio-inline"><input  name="paymentType" value="SB" type="radio">Сбербанк Онлайн</label><br/>

        <label class="radio-inline"><input  name="paymentType" value="WM" type="radio">кошелек WebMoney</label><br/>

        <br>

        <input class="btn btn-lg btn-primary btn-block" type=submit value="Оплатить"><br>

    </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
