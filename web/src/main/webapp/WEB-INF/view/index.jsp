<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/global.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/header.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/index.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/footer.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/path.css"/> ">
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/menu.css"/> ">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>


<jsp:include page="${lang.lang}/header.jsp"/>
<jsp:include page="path.jsp"/>
<div id="container">
    <jsp:include page="menu.jsp"/>


    <div id="news">
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
        <div id="items">
            <c:if test="${not empty products}">
                <c:forEach var="product" items="${products}">
                    <div class="item">
                        <div class="item-image">
                            <a><img src="${lang.resources}/resources/images/nofoto.png"></a>
                        </div>
                        <span><a href="${lang.context}/product/${product.id}">${product.name}</a></span>
                    </div>
                </c:forEach>
            </c:if>
        </div>

    </div>
</div>
<div id="footer"></div>
</body>
</html>
