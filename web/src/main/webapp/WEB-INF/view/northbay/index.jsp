<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/global.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/header.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/index.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/footer.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/northbay/menu.css"/>"/>


    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery.jcarousel.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="${lang.resources}/resources/css/jcarousel.basic.css">

    <script type="text/javascript" src="${lang.resources}/resources/js/jcarousel.basic.js"></script>

    <script type="text/javascript" src="jcarousel.basic.js"></script>

    <meta name='yandex-verification' content='434ddf413b52bfe4'/>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>


<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div class="jcarousel-wrapper">
        <div class="jcarousel">
            <ul>
                <li><a><img src="http://images.${lang.lang}.ru/carousel/image_carousel_1.jpg"></a></li>
                <li><a><img src="http://images.${lang.lang}.ru/carousel/image_carousel_2.jpg"></a></li>
                <li><a><img src="http://images.${lang.lang}.ru/carousel/image_carousel_3.jpg"></a></li>
                <li><a><img src="http://images.${lang.lang}.ru/carousel/image_carousel_4.jpg"></a></li>
            </ul>
        </div>

        <p class="photo-credits">
            <a href="http://northbay.ru">NORTHBAY</a>
        </p>

        <a href="#" class="jcarousel-control-prev">&lsaquo;</a>
        <a href="#" class="jcarousel-control-next">&rsaquo;</a>
        </p>
    </div>
    <h1>Новые поступления на <a href="http://northbay.ru/">northbay.ru</a></h1>
    <%--<div id="news">--%>
    <%--<div id="carusel">Тут будет карусель</div>--%>
    <%--<div id="news-list">--%>
    <%--<div class="news">--%>
    <%--<span>Открытый урок по нахлысту в Санкт-Петербурге</span>--%>
    <%--<article>--%>
    <%--Петровский пруд (рядом с Петровским стадионом), опоздавших небывает. Каждый раз на открытый урок--%>
    <%--приходят люди желающие только начать заниматься нахлыстом, нахлыстовики у которых есть те или иные--%>
    <%--вопросы по забросу, по технике и тактике ловли, в общем ждем всех.--%>
    <%--Нахлыстовиков и рыбаков ждет маленький сюрприз, тест катамаранов для нахлыстовиков.--%>
    <%--Приходите увидите все своими глазами.Тем более за летний период их явно накопилось много. Конечно--%>
    <%--ждем нахлыстовиков кто может что то посоветовать или рассказать про те или иные снасти или вообще--%>
    <%--про места ловли которые они посещали в прошлом. Не забываем и про мушки /правда для этого будут--%>
    <%--занятия по вязанию нахлыстовых мушек, в холодное время года/--%>
    <%--Нахлыстовиков и рыбаков ждет маленький сюрприз, тест катамаранов для нахлыстовиков. Приходите--%>
    <%--увидите все своими глазами.--%>
    <%--</article>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<h1>Последние поступления на ${lang.context}</h1>--%>
    <%--</div>--%>


    <div id="items">
        <c:if test="${not empty products}">
            <c:set var="i" value="0"/>
            <c:forEach var="product" items="${products}">
            <c:if test="${i==0}">
            <div class="row-item">
                </c:if>
                <div class="item">
                    <div class="item-image">
                        <c:choose>
                            <c:when test="${not empty product.image}">
                                <a href="${lang.context}/product/${product.id}"><img
                                        src="${product.image}" width="170px"></a>
                            </c:when>
                            <c:otherwise>
                                <a href="${lang.context}/product/${product.id}"><img
                                        src="${lang.resources}/resources/images//nofoto.png"></a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <a href="${lang.context}/product/${product.id}">${product.name}</a>
                </div>
                    <c:set var="i" value="${i+1}"/>
                <c:if test="${i==5}">
                    </div>
                    <c:set var="i" value="0"/>
                </c:if>
            </c:forEach>
        </c:if>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
