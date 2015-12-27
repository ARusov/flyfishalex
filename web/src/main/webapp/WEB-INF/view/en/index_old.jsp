<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/global.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/header.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/index.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/footer.css"/>"/>
    <link rel="stylesheet" href="<c:url value="${lang.resources}/resources/css/en/menu.css"/>"/>


    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="${lang.resources}/resources/js/jquery.jcarousel.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="${lang.resources}/resources/css/en/jcarousel.basic.css">

    <script type="text/javascript" src="${lang.resources}/resources/js/jcarousel.basic.js"></script>

    <script type="text/javascript" src="jcarousel.basic.js"></script>

    <meta name='yandex-verification' content='40c2ef64a3b9c004'/>
    <title>Интернет-магазин FlyFishAlex.ru</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="verticalMenu.jsp"/>
<div id="container">
    <div class="jcarousel-wrapper">
        <div class="jcarousel">
            <ul>
                <li><a><img src="http://images.visionfishing.ru/vision/carousel/image_carousel_1.jpg"></a></li>
                <li><a><img src="http://images.visionfishing.ru/vision/carousel/image_carousel_2.jpg"></a></li>
                <li><a><img src="http://images.visionfishing.ru/vision/carousel/image_carousel_3.jpg"></a></li>
                <li><a><img src="http://images.visionfishing.ru/vision/carousel/image_carousel_4.jpg"></a></li>
            </ul>
        </div>

        <p class="photo-credits">
            <a href="${lang.context}">FlyFishAlex.ru</a>
        </p>
        <a href="#" class="jcarousel-control-prev">&lsaquo;</a>
        <a href="#" class="jcarousel-control-next">&rsaquo;</a>
        </p>
    </div>

    <div id="items">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="item">
                    <div class="item-image">
                        <c:choose>
                            <c:when test="${not empty product.image}">
                                <a href="${lang.context}/product/${product.id}"><img
                                        src="http://images.enfishing.ru/products/${product.id}/${product.image}" width="170px"></a>
                            </c:when>
                            <c:otherwise>
                                <a href="${lang.context}/product/${product.id}"><img
                                        src="${lang.resources}/resources/images/nophoto_en.png"></a>
                            </c:otherwise>
                        </c:choose>
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
