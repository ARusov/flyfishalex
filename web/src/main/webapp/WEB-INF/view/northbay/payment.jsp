<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/payment.css"/>">
    <title>Интернет-магазин Northbay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="container">
    <h2>Оплата заказа ${orderId}</h2>

    <form name="ShopForm" method="POST" action="https://money.yandex.ru/eshop.xml">

        <font face="tahoma" size="2"/>

        <input type="hidden" name="shopId" value="48026">

        <input type="hidden" name="scid" value="39863">

        <%--Идентификатор пользователя:<br>--%>

        <input class="edit_row" type=hidden name="CustomerNumber" size="64" value="${userId}">

        Сумма (руб.):<br>

        <input class="edit_row" type=text name="sum" size="64" value="${price}"><br><br>


        <input name="orderNumber" value="${orderId}" type="hidden"/>

        <input name="shopSuccessURL" value="${lang.context}/paymentSuccess" type="hidden"/>

        <input name="shopFailURL" value="${lang.context}/paymentFail" type="hidden"/>

        Способ оплаты:<br><br>

        <input name="paymentType" value="PC" type="radio" checked="checked"/>Со счета в Яндекс.Деньгах (яндекс
        кошелек)<br/>

        <input name="paymentType" value="AC" type="radio"/>С банковской карты<br/>

        <input name="paymentType" value="SB" type="radio"/>Сбербанк Онлайн<br/>

        <input name="paymentType" value="WM" type="radio"/>кошелек WebMoney<br/>


        <!--

        AB - Альфа-Клик

        AC - банковская карта

        GP - наличные через терминал

        MA - MasterPass

        MC - мобильная коммерция

        PB  -интернет-банк Промсвязьбанка

        PC - кошелек Яндекс.Денег

        SB - Сбербанк Онлайн

        WM - кошелек WebMoney

        -->

        <br>

        <input class="edit_row" type=submit value="Оплатить"><br>

    </form>

</div>
<!-- Тестовый яндекс.кошелек

(прежде чем использовать тестовый яндекс.кошелек, обязательно войдите в https://demomoney.yandex.ru с указанными ниже логином и паролем)



Test-for-yamoney@yandex.ru

Пароль для входа: yamoney

Платежный пароль: testforyamoney

-->


<!-- Тестовая банковская карта



Номер карты: 4268 0337 0354 5624

Действует до: любая дата в будущем

Имя и фамилия владельца: любое имя латиницей, например, IVAN DEMIDOV

Код CVV: 123

Email: свой e-mail



Код CVC: 123

-->


<!--

Пример ответа на POST запрос к CheckURL

<?xml version="1.0" encoding="utf-8"?>

<checkOrderResponse performedDatetime="2015-06-23T08:59:16+03:00" code="1" shopId="" invoiceId=""/>



Пример ответа на paymentAviso при успехе обработки:

<?xml version="1.0" encoding="UTF-8"?>

<paymentAvisoResponse performedDatetime ="2011-05-04T20:38:11.000+04:00" code="0" invoiceId="1234567" shopId="13"/>

-->


<!--

EPS и PNG файлы яндекс.кошелька

https://money.yandex.ru/partners/doc.xml?id=522991



EPS и PNG других платежных методов

https://money.yandex.ru/doc.xml?id=526421

-->
<jsp:include page="footer.jsp"/>
</body>
</html>
