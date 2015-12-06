<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<h2>Тестирование в демо-среде Яндекс.Касса</h2>

<!-- Пример в кодировке UTF-8 (обязательно используйте именно эту кодировку для взаимодействия с Яндекс.Кассой)

Внимание! Это только пример. Для того, чтобы он работал, обязательно пропишите в нем shopId и scid, который мы присылаем в письме на ваш контактный e-mail.

Кроме того вам надо реализовать программную часть для CheckOrderURL и AvisoURL.

-->

<form name="ShopForm" method="POST" action="https://demomoney.yandex.ru/eshop.xml">

    <font face="tahoma" size="2"/>

    <input type="hidden" name="shopId" value="104002">

    <input type="hidden" name="scid" value="527913">

    Идентификатор клиента:<br>

    <input type=text name="CustomerNumber" size="64" value="${userId}"><br><br>

    Сумма (руб.):<br>

    <input type=text name="sum" size="64" value="${price}"><br><br>


    <!-- CustomerNumber -- до 64 символов; идентификатор плательщика в ИС Контрагента.

    В качестве идентификатора может использоваться номер договора плательщика, логин плательщика и т.п.

    Возможна повторная оплата по одному и тому же идентификатору плательщика.



    sum -- сумма заказа в рублях.

    -->


    <!-- необязательные поля (все параметры яндекс.кассы регистрозависимые) -->

    <input name="orderNumber" value="${orderId}" type="hidden"/>

    <input name="shopSuccessURL" value="${lang.context}/paymentSuccess" type="hidden"/>

    <input name="shopFailURL" value="${lang.context}/paymentFail" type="hidden"/>


    <!-- Внимание! Для тестирования в ДЕМО-среде доступны только два метода оплаты: тестовый Яндекс.Кошелек и Тестовая банковская карта

    -->

    Способ оплаты:<br><br>

    <input name="paymentType" value="PC" type="radio" checked="checked"/>Со счета в Яндекс.Деньгах (яндекс кошелек)<br/>

    <input name="paymentType" value="AC" type="radio"/>С банковской карты<br/>


    <!--

    Ниже перечислены доступные формы оплаты.

    Перечисленные методы оплаты могут быть доступны в боевой среде после подписания Договора.

    Какие именно методы доступны для вашего Договора, вы можете уточнить у своего персонального менеджера.



    AB - Альфа-Клик

    AC - банковская карта

    GP - наличные через терминал

    MA - MasterPass

    MC - мобильная коммерция

    PB  -интернет-банк Промсвязьбанка

    PC - кошелек Яндекс.Денег

    SB - Сбербанк Онлайн

    WM - кошелек WebMoney



    <input name="paymentType" value="GP" type="radio">Оплата по коду через терминал<br>

    <input name="paymentType" value="WM" type="radio">Оплата cо счета WebMoney<br>

    <input name="paymentType" value="AB" type="radio">Оплата через Альфа-Клик<br>

    <input name="paymentType" value="PB" type="radio">Оплата через Промсвязьбанк<br>

    <input name="paymentType" value="MA" type="radio">Оплата через MasterPass<br>

    -->

    <br>

    <input type=submit value="Оплатить"><br>

</form>

<hr/>

Документация: <a href="https://money.yandex.ru/doc.xml?id=526537">https://money.yandex.ru/doc.xml?id=526537</a>


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

</body>
</html>
