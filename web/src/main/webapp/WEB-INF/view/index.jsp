<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/index.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/>"/>


    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>

    <meta name='yandex-verification' content='434ddf413b52bfe4'/>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>


<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="path.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
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
            <c:forEach var="product" items="${products}">
                <div class="item">
                    <div class="item-image">
                        <a href="${lang.context}/product/${product.id}"><img
                                src="${lang.resources}/resources/images/nofoto.png"></a>
                    </div>
                    <a href="${lang.context}/product/${product.id}">${product.name}</a>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
