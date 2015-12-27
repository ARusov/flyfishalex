<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/css/custom.css"/>"
          rel="stylesheet">
    <title>Магазин</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="verticalMenu.jsp"/>
<div class="container">
    <div class="page-header">
        <h1>${category.name} на <a href="http://northbay.ru/">northbay.ru</a></h1>
    </div>

    <div class="flex-row row">
        <c:if test="${not empty categories}">
            <jsp:include page="menu.jsp"/>
        </c:if>
        <%--categories--%>
        <c:forEach var="category" items="${categories}">
            <div class="col-xs-6 col-md-2 ">
                <a href="${lang.context}/category/${category.id}" class="thumbnail">
                    <div class="caption center-block">
                        <img src="${lang.resources}/resources/images/nofoto.png"/>

                        <h3 class="text-center flex-text">${category.text}</h3>

                        <p>
                            <button type="button" class=" lnk btn-xs btn-primary center-block">Подробнее</button>
                        </p>
                    </div>
                </a>
            </div>
        </c:forEach>


        <%--products--%>
        <c:set var="i" value="0"/>
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

    </div>
    <jsp:include page="footer.jsp"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="${lang.resources}/resources/css/northbay/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
