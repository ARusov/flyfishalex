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
    <title>Доставка Vision Fishing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>

<div id="container">
    <p>&nbsp;Курьерская доставка по Санкт-Петербургу и Ленинградской области осуществляется собственной курьерской
        службой:
    <ul>
        <li> Доставка будет осуществлена курьером интернет-магазина <a href="http://visionfishing.ru/">Vision
            Fishing</a></li>
        <li>Доставка может быть осуществлена в любой день недели по предварительному согласованию с менеджером
            магазина.
        </li>
        <li>Стоимость курьерской доставки по Санкт-Петербургу в пределах КАД — 300 руб</li>
        <li>При заказе на сумму превышающую 5000 руб., доставка в пределах КАД осуществляется бесплатно.
            Стоимость доставки за пределы КАД оговаривается индивидуально с менеджером магазина.
        </li>
    </ul>
    </p>
  
    <p>
        &nbsp;доставка по России и СНГ
    <ul>
        <li>
            Почта России — данный вид доставки имеет наибольший охват территории. Сроки и цена доставки зависит от Вашей
            страны и региона проживания. С ценами доставки можно ознакомиться на сайте Почты России.
        </li>
        <li>ЕМС Почта России — меньшие сроки доставки по сравнению с обычной почтой. С тарифами можно ознакомится на
            официальном сайте.
            Если товар крупногабаритный, то наиболее удобным способом будет доставка транспортной компанией.
        </li>
        <li>Транспортная компания «Деловые линии» — один из лидеров по оказанию транспортно-логистических услуг.
            Существует с 2001 года, благодаря чему накопили богатый опыт и зарекомендовали себя как надежный партнер для
            огромного числа клиентов. Крупногабаритные товары могут быть отправлены во все регионы России и страны СНГ.
        </li>
        <li>Служба доставки DPD — DPD предлагает полный комплекс качественных транспортно-логистических решений для
            внутренней и международной доставки ваших посылок и грузов по оптимальным тарифам
        </li>
    </ul>
    </p>
    <p>&nbsp;Способы доставки постоянно обновляются, для более точной информации Вы можете обратиться к нашим
        менеджерам</p>

    <p>&nbsp;Ждем Вас в нашем интернет магазине</p>

    <p>&nbsp;Всегда к Вашим услугам, коллектив нахлыстового интернет магазина <a href="http://visionfishing.ru/">Vision
        Fishing</a>!</p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
