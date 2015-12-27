<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
        <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <meta name='yandex-verification' content='434ddf413b52bfe4'/>
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<%--<jsp:include page="header.jsp"/>--%>
<jsp:include page="verticalMenu.jsp"/>

<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="http://images.${lang.lang}.ru/carousel/image_carousel_1.jpg" alt="Chania">
                <div class="carousel-caption">
                    <h3>Chania</h3>
                    <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                </div>
            </div>

            <div class="item">
                <img src="http://images.${lang.lang}.ru/carousel/image_carousel_2.jpg" alt="Chania">

                <div class="carousel-caption">
                    <h3>Chania</h3>

                    <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                </div>
            </div>

            <div class="item">
                <img src="http://images.${lang.lang}.ru/carousel/image_carousel_3.jpg" alt="Flower">

                <div class="carousel-caption">
                    <h3>Flowers</h3>

                    <p>Beatiful flowers in Kolymbari, Crete.</p>
                </div>
            </div>

            <div class="item">
                <img src="http://images.${lang.lang}.ru/carousel/image_carousel_4.jpg" alt="Flower">

                <div class="carousel-caption">
                    <h3>Flowers</h3>

                    <p>Beatiful flowers in Kolymbari, Crete.</p>
                </div>
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="page-header">
        <h1>Новые поступления на <a href="http://northbay.ru/">northbay.ru</a></h1>
    </div>
    <div class="flex-row row">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="col-xs-6 col-md-2 ">
                    <a href="${lang.context}/product/${product.id}" class="thumbnail">
                        <div class="caption center-block">
                            <c:choose>
                                <c:when test="${not empty product.image}">
                                    <img src="${product.image}" width=170px>
                                </c:when>
                                <c:otherwise>
                                    <img src="${lang.resources}/resources/images/nofoto.png"/>
                                </c:otherwise>
                            </c:choose>
                            <h3 class="text-center flex-text">${product.name}</h3>
                            <p>
                                <button type="button" class=" lnk btn-xs btn-primary center-block">Подробнее</button>
                            </p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

<jsp:include page="footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
